package com.sensi.classification;

import java.util.ArrayList;
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
import weka.filters.unsupervised.attribute.StringToWordVector;

import com.sensi.domain.Corpus;
import weka.classifiers.Evaluation;
import weka.core.SparseInstance;

/**
 * 
 * @author <a href="mailto:maas_dianto@xybase.com">Maas Dianto</a>
 * @version 1.0 - Jun 19, 2012
 */
public class SensiClassifier {

    Logger logger = LoggerFactory.getLogger(SensiClassifier.class);
    private static final int INSTANCES_CAPACITY = 1000;
    private static final String DELIMITERS_WORD_VECTOR = "\\s.,:'\\\"()?!";
    private List<Corpus> corpuses;
    private String algoritmClass = "weka.classifiers.bayes.NaiveBayes";
    private Classifier classifier;
    private Evaluation evaluation;
    private Instances datasetInstances;
    private HashSet corpusModel;
    private Attribute categoryAttribute;
    private Attribute textAttribute;
    List<String> listText;
    List<String> listClass;

    /**
     * Constructor with parameter List of Corpuses With this constructor,
     * classifier will user algoritm
     * <i>weka.classifiers.bayes.NaiveBayes</i>
     *
     * @param corpuses
     *            List of Corpuses to train
     */
    public SensiClassifier(final List<Corpus> corpuses) {
        this.corpuses = corpuses;
        this.initialize();
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
        this.initialize();
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
        categoryAttribute = new Attribute("category", categoryVector);

        FastVector textVector = new FastVector();
        for (String text : listText) {
            textVector.addElement(text);
        }
        textAttribute = new Attribute("text", textVector);

        FastVector attributeInfo = new FastVector();
        attributeInfo.addElement(textAttribute);
        attributeInfo.addElement(categoryAttribute);

        datasetInstances = new Instances("DATASET", attributeInfo, INSTANCES_CAPACITY);
        datasetInstances.setClass(categoryAttribute);

        datasetInstances = populateInstances(listText, listClass, datasetInstances, categoryAttribute, textAttribute);

    }

    /**
     * Train data now !!
     */
    public void train() {

        StringToWordVector filter = new StringToWordVector(1000);

        Instances instancesFiltered = filterInstances(datasetInstances);

        corpusModel = new HashSet();
        Enumeration attributeFiltered = instancesFiltered.enumerateAttributes();

        while (attributeFiltered.hasMoreElements()) {
            Attribute attribute = (Attribute) attributeFiltered.nextElement();
            String attributeName = attribute.name().toLowerCase();
            corpusModel.add(attributeName);
        }

        try {
            classifier = Classifier.forName(algoritmClass, null);
            classifier.buildClassifier(instancesFiltered);
            evaluation = new Evaluation(instancesFiltered);
            evaluation.evaluateModel(classifier, instancesFiltered);
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
    public StringBuffer classify(final List<String> textToClassify) {
        StringBuffer result = new StringBuffer();

        Instances textInstances = new Instances(datasetInstances);
        textInstances.setClass(categoryAttribute);

        List<String> textInModel = new ArrayList<String>();
        int num = 0;

        for (int i = 0; i < textToClassify.size(); i++) {
            StringBuffer sb = new StringBuffer();

            // split
            String[] splittedText = textToClassify.get(i).split("[" + DELIMITERS_WORD_VECTOR + "]");
            // check word availability on model
            for (int j = 0; j < splittedText.length; j++) {
                String text = splittedText[j];
                if (corpusModel.contains((String) text)) {
                    num++;
                    sb.append(text + " ");
                }
            }

            textInModel.add(i, sb.toString().trim());
        }

        if (num == 0) {
            throw new CorpusException("Cannot Calssify : text to tlassify didn't contain any  words from the corpuses model.");
        }

        try {
            List<String> tmpCategory = new ArrayList<String>();
            for (int i = 0; i < textToClassify.size(); i++) {
                tmpCategory.add("?");
            }
            textInstances = populateInstances(textInModel, tmpCategory, textInstances, categoryAttribute, textAttribute);
            Instances textInstancesFiltered = filterInstances(textInstances);

            int start = datasetInstances.numInstances();
            result = getResult(textInstancesFiltered, textToClassify, "classify", start);
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
        }

        return result;
    }

    /**
     * Classify a word
     *
     * @param word, the word to classify
     */
    public StringBuffer classify(final String textToClassify) {
        StringBuffer result = new StringBuffer();

        List<String> textToList = new ArrayList<String>();
        textToList.add(textToClassify);

        Instances textInstances = new Instances(datasetInstances);
        textInstances.setClass(categoryAttribute);

        List<String> textInModel = new ArrayList<String>();
        int num = 0;

        StringBuffer sb = new StringBuffer();

        // split
        String[] splittedText = textToClassify.split("[" + DELIMITERS_WORD_VECTOR + "]");
        // check word availability on model
        for (int j = 0; j < splittedText.length; j++) {
            String text = splittedText[j];
            if (corpusModel.contains((String) text)) {
                num++;
                sb.append(text + " ");
            }
        }

        textInModel.add(sb.toString().trim());

        if (num == 0) {
            throw new CorpusException("Cannot Calssify : text to tlassify didn't contain any  words from the corpuses model.");
        }

        try {
            List<String> tmpCategory = new ArrayList<String>();
            tmpCategory.add("?");

            textInstances = populateInstances(textInModel, tmpCategory, textInstances, categoryAttribute, textAttribute);
            Instances textInstancesFiltered = filterInstances(textInstances);

            int start = datasetInstances.numInstances();
            result = getResult(textInstancesFiltered, textToList, "classify", start);
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
        }

        return result;
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

    public Instances filterInstances(Instances instances) {
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

    /**
     * Show information about Classifier and Evaluation
     * Call this method when you want know the detail of your data training
     *
     * @return {@link StringBuffer}
     */
    public StringBuffer showClassifierAndEvaluationInfo() {
        StringBuffer result = new StringBuffer();

        try {
            result.append("\n\nINFORMATION ABOUT THE CLASSIFIER AND EVALUATION:\n");
            result.append("\nclassifier.toString():\n" + classifier.toString() + "\n");
            result.append("\nevaluation.toSummaryString(title, false):\n" + evaluation.toSummaryString("Summary", false) + "\n");
            result.append("\nevaluation.toMatrixString():\n" + evaluation.toMatrixString() + "\n");
            result.append("\nevaluation.toClassDetailsString():\n" + evaluation.toClassDetailsString("Details") + "\n");
            result.append("\nevaluation.toCumulativeMarginDistribution:\n" + evaluation.toCumulativeMarginDistributionString() + "\n");
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            result.append("\nException :\n" + ex.toString());
        }

        return result;
    }

    public StringBuffer getResult(Instances instances, List<String> listText, String type, int start) {
        StringBuffer sb = new StringBuffer();

        try {
            sb.append("\nRESULT:\n");

            Enumeration enumClasses = categoryAttribute.enumerateValues();
            sb.append("Class values (in order): ");
            while (enumClasses.hasMoreElements()) {
                String classStr = (String) enumClasses.nextElement();
                sb.append("'" + classStr + "'  ");
            }
            sb.append("\n");

            // startIx is a fix for handling text cases
            for (int i = start; i < instances.numInstances(); i++) {

                SparseInstance sparseInst = new SparseInstance(instances.instance(i));
                sparseInst.setDataset(instances);

                sb.append("\nTesting: '" + listText.get(i - start) + "'\n");

                double correctValue = (double) sparseInst.classValue();
                double predictedValue = classifier.classifyInstance(sparseInst);

                String predictString = categoryAttribute.value((int) predictedValue) + " (" + predictedValue + ")";
                sb.append("predicted: '" + predictString);
                if (!"train".equals(type)) {
                    String correctString = categoryAttribute.value((int) correctValue) + " (" + correctValue + ")";
                    String testString = ((predictedValue == correctValue) ? "OK!" : "NOT OK!") + "!";
                    sb.append("' real class: '" + correctString + "' ==> " + testString);
                }
                sb.append("\n");
            }
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
        }

        return sb;
    }
}
