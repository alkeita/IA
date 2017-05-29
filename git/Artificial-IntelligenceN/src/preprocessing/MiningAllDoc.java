/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preprocessing;

import edu.stanford.nlp.process.Stemmer;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import model.DocumentModel;

/**
 *
 * @author Prince Al Keita
 */
public class MiningAllDoc {
	
	ArrayList<ArrayList<Integer>> frequencyDocuments ;
        Vector<String> wordsDocuments ;
        List<DocumentModel> documents;
        double[] queryWordPertinence ;
        String[] wordVector;
     
	public MiningAllDoc(List<DocumentModel> documents1){
            this.documents=documents1;
           frequencyDocuments = new ArrayList<ArrayList<Integer>>();
           wordsDocuments = new Vector<String>();
        for (DocumentModel dm : documents) {
               for(int i=0;i<dm.getFrequency().size();i++){
                    if(!wordsDocuments.contains(dm.getWords().get(i))){
                         wordsDocuments.add(dm.getWords().get(i));
                    }    
                }
	     }
        }
        public void stemmingAllDoc(){
           
            
            for (int i=0;i<documents.size();i++) {
                DocumentModel dm=documents.get(i);
                 ArrayList<Integer> frequency= new ArrayList<Integer>();
                   for (String word : wordsDocuments) {
			int idx = indexOfWordInVectorAll(word);
                        int val=dm.getStemming().getOccurence(word);
                	frequency.add(val);
			
		}
                   // System.out.println(frequency.size());
                   frequencyDocuments.add(frequency);
            }
           
            //System.out.println(frequencyDocuments.size());
           // printFrequency();
        }
        public int indexOfWordInVectorAll(String word) {
		for (int i = 0; i < wordsDocuments.size(); i++) {
			if (wordsDocuments.get(i).equalsIgnoreCase(word)) {
				return i;
			}
		}
		return -1;
	}
        public void queryUpdate(String word){
             wordVector=word.split(" ");
             queryWordPertinence=new double[wordVector.length];
            for(int i=0;i<wordVector.length;i++){
                queryWordPertinence[i]=getWordPertience(wordVector[i]);
                System.out.println("pertinence of word :"+wordVector[i]+" is :"+queryWordPertinence[i]);
            }
            
            
        }
        
        
        private double getWordPertience(String word){
            double occurInAllDoc=0;
            double idf=0;
             for (DocumentModel dm : documents) {		
				Stemming stemming=dm.getStemming();
				
				int frequencyInDoxument=stemming.getOccurence(word);
				if(frequencyInDoxument>0){
					occurInAllDoc+=frequencyInDoxument;
				}
				
			} 
                        if(occurInAllDoc>0)
			idf=Math.log10(occurInAllDoc/(double)documents.size());
                   return idf;
        }
         public List<DocumentModel> getScore(){
             List<DocumentModel> documentsF=new ArrayList<DocumentModel>();
    	 for (DocumentModel dm : documents) {
                                double tfIfdWord;
                                double tfIfdWordVector=0;
                                double tf;
				System.out.println(dm.getName());
				dm.printFrequency();
				Stemming stemming=dm.getStemming();
                                for (int i = 0; i < wordVector.length; i++) {
                                        tf=stemming.getTermFrequency(wordVector[i]);
                                        tfIfdWord=tf*queryWordPertinence[i];
                                        tfIfdWordVector+=tfIfdWord;
                                }
				dm.setTfIdf(tfIfdWordVector);
                                
				 if(documentsF.isEmpty()){
                                    documentsF.add(0, dm);
                                }else{
                                    int x=0;
                                    while(x<documentsF.size()&& documentsF.get(x).getTfIdf()>dm.getTfIdf()){
                                       x++;     
                                    }
                                    documentsF.add(x,dm);
                                }
				
				
			}
                        for (DocumentModel dm : documentsF) {
                            System.out.println("score file :"+dm.getName()+"via get is"+dm.getTfIdf());
                        }
                        return documentsF;
			
			
     }
    
    

        
       /* public void printFrequency(){
		String fileName = "documents\\" + "wirdDocuments.txt";
		PrintWriter pw;
                
		try {
			pw = new PrintWriter(fileName, "UTF-8");
                        for (int i = 0; i < frequencyDocuments.size(); i++) {
                            
                            for (int j = 0; j < wordsDocuments.size(); j++) {
                                pw.print(frequencyDocuments.get(i).get(j)+" ");
                            }	
                            pw.println("");
			}
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}*/
    
    
}
