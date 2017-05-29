package preprocessing;

import java.util.List;
import java.util.Vector;

import edu.stanford.nlp.process.Stemmer;

public class Stemming {

	private Vector<String> words;
	private Vector<Integer> frequency;
	private Stemmer stem;
	private int termFrequency;
	private int inversDocFrequency;
        private double[] queryFrequency;


	public Stemming() {
		words = new Vector<String>();
		frequency = new Vector<Integer>();
		stem = new Stemmer();
	}

	public void stemming(List<String> w) {
		for (String word : w) {
			String wordStemmed = stem.stem(word);
			int idx = indexOfWordInVector(wordStemmed);
			if (idx >= 0) {
				frequency.set(idx, frequency.get(idx) + 1);
			} else {
				words.add(wordStemmed);
				frequency.add(1);
			}
		}
                queryFrequency=new double[words.size()];
                for(int i=0;i<words.size();i++){
                    queryFrequency[i]=0;
                }
		
		
		
	}
        
        public void setQueryfrequency(String word){
            int index=indexOfWordInVector(word);
            if(index>=0)
            queryFrequency[index]=getTermFrequency(word);
        }
                public double[] getqueryFrequency(){
            return queryFrequency;
        }

	public int indexOfWordInVector(String word) {
		for (int i = 0; i < words.size(); i++) {
			if (words.get(i).equalsIgnoreCase(word)) {
				return i;
			}
		}
		return -1;
	}

	public Vector<String> getWords() {
		return words;
	}

	public Vector<Integer> getFrequency() {
		return frequency;
	}
	public double getTermFrequency(String word){
		if(indexOfWordInVector(word)<0)
			return 0;
		double term=(double) frequency.get(indexOfWordInVector(word))/(double)words.size();
		return term;
		
	}
	public int getOccurence(String word){
		if(indexOfWordInVector(word)<0)
			return 0;
		return frequency.get(indexOfWordInVector(word));
	}

}
