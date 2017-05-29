package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Vector;

import preprocessing.NamedEntityRecognition;
import preprocessing.Stemming;
import preprocessing.TextExtractor;

public class DocumentModel {

	private String name;
	private Vector<String> words;
	private Vector<Integer> frequency;
	private Stemming stemming;
        private double tfIdf;

	
	public DocumentModel(File f) {
		String text = null;
		TextExtractor textExtractor = new TextExtractor();
		NamedEntityRecognition ner = new NamedEntityRecognition();
		stemming = new Stemming();
		text = textExtractor.extractText(f.getPath());
		ner.recognitionWords(text);
		stemming.stemming(ner.getWords());
		this.name = f.getName();
		this.words = stemming.getWords();
		this.frequency = stemming.getFrequency();
                this.tfIdf=0;
	}

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Vector<String> getWords() {
		return words;
	}

	public void setWords(Vector<String> words) {
		this.words = words;
	}

	public Vector<Integer> getFrequency() {
		return frequency;
	}
	public Stemming getStemming(){
		return stemming;
	}
        public double getTfIdf(){
            return tfIdf;
        }
        public void setTfIdf(double tfIdf){
            this.tfIdf=tfIdf;
        }
	public void setFrequency(Vector<Integer> frequency) {
		this.frequency = frequency;
	}
	public void printFrequency(){
		String fileName = "documents\\" + name.replaceAll("[.].*", ".txt");
		PrintWriter pw;
		try {
			pw = new PrintWriter(fileName, "UTF-8");
			for (int i = 0; i < words.size(); i++) {
				pw.println(words.get(i) + " - " + frequency.get(i));
			}
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
        
	

}
