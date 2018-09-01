package pathak;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.List;

import edu.stanford.nlp.ling.Sentence;
import edu.stanford.nlp.ling.TaggedWord;
import edu.stanford.nlp.ling.HasWord;
import edu.stanford.nlp.tagger.maxent.MaxentTagger;

class TaggerDemo {
	
  private TaggerDemo() {}

  public static void main(String[] args) throws Exception {
    //if (args.length != 2) {
      //System.err.println("usage: java TaggerDemo modelFile fileToTag");
      //return;
    //}
	 String pathofwriter= "/home/amarnath/Amarnath/My Course work/NLP/NLP Tools/stanford-postagger-full-2015-12-09/taggedsentences.txt";
	String pathoftagger ="/home/amarnath/Amarnath/My Course work/NLP/NLP Tools/stanford-postagger-full-2015-12-09/models/english-bidirectional-distsim.tagger";
	String pathofsource="/home/amarnath/Amarnath/My Course work/NLP/NLP Tools/stanford-postagger-full-2015-12-09/sentences.txt"; 
	PrintWriter pw=new PrintWriter(pathofwriter); 
    MaxentTagger tagger = new MaxentTagger(pathoftagger);
    List<List<HasWord>> sentences = MaxentTagger.tokenizeText(new BufferedReader(new FileReader(pathofsource)));
      for (List<HasWord> sentence : sentences) {
    	  /*
    	  System.out.println(Sentence.listToString(sentence, false));
      List<TaggedWord> tSentence = tagger.tagSentence(sentence);    
      pw.println(Sentence.listToString(tSentence, false));
      System.out.println(Sentence.listToString(tSentence, false));
      */	System.out.println(Sentence.listToString(sentence, false));
    	  String tsentence=tagger.tagString(Sentence.listToString(sentence, false));
    	  System.out.println(tsentence);
    }
    pw.close();
  }

}