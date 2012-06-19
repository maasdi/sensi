/**
 * SensiClassifier.java
 *
 * eBio-MOH gateway version 1.0
 * Licensed Material - Property of XYBASE.
 * Copyright (C) 2006 XYBASE SDN BHD. All rights reserved.
 */
package com.sensi.classification;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import weka.classifiers.Classifier;
import weka.core.Attribute;
import weka.core.FastVector;
import weka.core.Instance;
import weka.core.Instances;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.StringToWordVector;

import com.sensi.domain.Corpus;

/**
 * 
 * @author <a href="mailto:maas_dianto@xybase.com">Maas Dianto</a>
 * @version 1.0 - Jun 19, 2012
 */
public class SensiClassifier {

	Logger logger = LoggerFactory.getLogger(SensiClassifier.class);

	private static final int INSTANCES_CAPACITY = 1000;
	private List<Corpus> corpuses;
	private String algoritmClass = "weka.classifiers.bayes.NaiveBayes";

	private Classifier classifier;
	private Instances modelInstances;
	
	List<String> listText;
	List<String> listClass;

	/**
	 * Constructor with parameter List of Corpuses With this constructor,
	 * classifier will user algoritm
	 * <i><i>weka.classifiers.bayes.NaiveBayes</i></i>
	 * 
	 * @param corpuses
	 *            List of Corpuses to train
	 */
	public SensiClassifier(final List<Corpus> corpuses) {
		this.corpuses = corpuses;
	}

	/**
	 * Constructor with to parameter use this Constructor if you want to set
	 * specific of Weka algoritm
	 * 
	 * @param corpuses
	 *            List of Corpuses to train
	 * @param aloritmClass
	 *            the algoritm class name, default value
	 *            <i>weka.classifiers.bayes.NaiveBayes</i>
	 */
	public SensiClassifier(final List<Corpus> corpuses,
			final String algoritmClass) {
		this.corpuses = corpuses;
		this.algoritmClass = algoritmClass;
	}

	/**
	 * Initialization SensiClassifier
	 */
	private void initialize() {
		// find unique wordClass
		HashSet<String> categorySet = new HashSet<String>();
		// hold text and class
		listText = new ArrayList<String>();
		listClass = new ArrayList<String>();
		for (Corpus corpus : corpuses) {
			categorySet.add(corpus.getCategory());
			listText.add(corpus.getText());
			listClass.add(corpus.getCategory());
		}
		// add class '?' as tag for unknown class
		categorySet.add("?");
		
		FastVector categoryVector = new FastVector();
		for (String category : listClass) {
			categoryVector.addElement(category);
		}
		Attribute categoryAttribute = new Attribute("category", categoryVector);
		
		FastVector textVector = new FastVector();
		for(String text : listText ){
			textVector.addElement(text);
		}
		Attribute textAttribute = new Attribute("text", textVector);
		
		FastVector attributeInfo = new FastVector();
		attributeInfo.addElement(textAttribute);
		attributeInfo.addElement(categoryAttribute);
		
		modelInstances = new Instances("DATASET", attributeInfo, INSTANCES_CAPACITY);
		modelInstances.setClass(categoryAttribute);
		
		modelInstances = populateInstances(listText, listClass, modelInstances, categoryAttribute, textAttribute);
		
	}

	/**
	 * Train data now !!
	 */
	public void train() {
		
		StringToWordVector filter = new StringToWordVector(1000);
		
		Instances instancesFiltered = filterText(modelInstances);
		
		HashSet modelWords = new HashSet();
		Enumeration attributeFiltered = instancesFiltered.enumerateAttributes();
		
		while(attributeFiltered.hasMoreElements()){
			Attribute attribute = (Attribute) attributeFiltered.nextElement();
			String attributeName = attribute.name().toLowerCase();
			modelWords.add(attributeName);
		}
		
		try {
			classifier = Classifier.forName(algoritmClass, null);
			classifier.buildClassifier(instancesFiltered);
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
		}
	}

	/**
	 * Classify List Of Words
	 * 
	 * @param textToClassify
	 *            Collection of words to classify
	 */
	public void classify(final List<String> textToClassify) {
		
	}

	/**
	 * Classify a word
	 * 
	 * @param word, the word to classify
	 */
	public void classify(final String word) {

	}
	
	private Instances populateInstances(List<String> listText, List<String> listClass, Instances instances, Attribute categoryAttribute, Attribute textAttribute) {

		for (int i = 0; i < listText.size(); i++) {
			Instance instance = new Instance(2);
			instance.setValue(textAttribute, listText.get(i));
			if (!listClass.equals(null) && listClass.size() > 0) {
				instance.setValue(categoryAttribute, listClass.get(i));
			}
			instances.add(instance);
		}
		return instances;

	} 
	
	public Instances filterText(Instances instances) {
		StringToWordVector filter = null;
		int wordsToKeep = INSTANCES_CAPACITY;

		Instances filtered = null;

		try {
			filter = new StringToWordVector(wordsToKeep);
			filter.setOutputWordCounts(true);
			filter.setSelectedRange("1");
			filter.setInputFormat(instances);
			filtered = weka.filters.Filter.useFilter(instances, filter);
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
		}

		return filtered;
	}

}
