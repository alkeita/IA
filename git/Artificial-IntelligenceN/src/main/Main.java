package main;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import edu.stanford.nlp.trees.DependencyScoring.Score;

import java.math.*;

import model.DocumentModel;
import preprocessing.NamedEntityRecognition;
import preprocessing.Stemming;
import preprocessing.TextExtractor;
import View.Interface1;
import preprocessing.MiningAllDoc;

public class Main {

	public static void main(String[] args) {

		String sFile = "test";
		String word="Swarm";
		File file = new File(sFile);
		List<DocumentModel> documents = new ArrayList<DocumentModel>();
		DocumentModel document = null;
		if (file.isDirectory()) {
			for (File f : Arrays.asList(file.listFiles())) {
				document=new DocumentModel(f);
				documents.add(document);                 
			}
		                  MiningAllDoc allDoc= new MiningAllDoc(documents);
                                  allDoc.stemmingAllDoc();

		}
                Interface1 inter= new Interface1(documents);
                inter.setSize(400,250);
                inter.setVisible(true);
	}
}
