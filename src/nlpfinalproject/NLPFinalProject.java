/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nlpfinalproject;

import edu.stanford.nlp.ling.HasWord;
import edu.stanford.nlp.ling.Sentence;
import edu.stanford.nlp.ling.TaggedWord;
import edu.stanford.nlp.tagger.maxent.MaxentTagger;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ryan
 */
public class NLPFinalProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {      
        if (args.length != 2) {
            System.err.println("usage: java TaggerDemo modelFile fileToTag");
            return;
        }
        MaxentTagger tagger = new MaxentTagger(args[0]);
        @SuppressWarnings("unchecked")
        List<List<HasWord>> sentences = tagger.tokenizeText(new BufferedReader(new FileReader(args[1])));
        for (List<HasWord> sentence : sentences) {
            ArrayList<TaggedWord> tSentence = tagger.tagSentence(sentence);
            System.out.println(Sentence.listToString(tSentence, false));
        }
    }
}
