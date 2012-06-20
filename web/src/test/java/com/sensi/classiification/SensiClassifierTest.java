/**
 *
 * @author <a href="mailto:maas.dianto@gmail.com">Maas Dianto</a>
 */
package com.sensi.classiification;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.sensi.classification.SensiClassifier;
import com.sensi.domain.Corpus;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class SensiClassifierTest {

    @Test
    public void testClassifierTest() {
        String[] inputText = {"hey, buy this from me!", "do you want to buy?", "I have a party tonight!", "today it is a nice weather", "you are best", "I have a horse", "you are my friend", "buy, buy, buy!", "it is spring in the air", "do you want to come?"};
        String[] inputClasses = {"spam", "spam", "no spam", "no spam", "spam", "no spam", "no spam", "spam", "no spam", "no spam"};

        List<Corpus> corpuses = new ArrayList<Corpus>();
        for (int i = 0; i < inputText.length; i++) {
            Corpus corpus = new Corpus();
            corpus.setId(new Long(i));
            corpus.setText(inputText[i]);
            corpus.setCategory(inputClasses[i]);
            corpuses.add(corpus);
        }

        List<String> textToClassify = new ArrayList<String>();
        textToClassify.add("you want to buy from me?");
        textToClassify.add("usually I run in stairs");
        textToClassify.add("buy it now!");
        textToClassify.add("buy, buy, buy!");
        textToClassify.add("you are the best, buy!");
        textToClassify.add("it is spring in the air");

        SensiClassifier sensiClassifier = new SensiClassifier(corpuses, "weka.classifiers.trees.J48");
        sensiClassifier.train();

        assertEquals(10, corpuses.size());
        assertEquals(6, textToClassify.size());
        
        assertTrue(sensiClassifier.getCorpusModel().contains("buy"));
       
        // must be notnull
        assertNotNull(sensiClassifier.classify(textToClassify));
        
        assertTrue(sensiClassifier.classify("you").getCategory().equals("no spam"));

    }
}
