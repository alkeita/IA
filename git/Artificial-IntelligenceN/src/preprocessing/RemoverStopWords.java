package preprocessing;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RemoverStopWords {

	private List<String> stop_words = new ArrayList<String>();

	/**
	 * Initialise la liste de mots sur base d'un fichier
	 */
	public RemoverStopWords() {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("stopwords_en.txt"));
			String line;

			while ((line = br.readLine()) != null) {
				stop_words.add(line.trim());
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Retire les mots inutiles du texte sur base d'une liste de mots
	 */
	public String remove_stop_words(String text) {
		for (String w : stop_words) {
			text = text.replaceAll("\\s*\\b" + w + "\\b\\s*", " ");
		}

		return text;
	}

}
