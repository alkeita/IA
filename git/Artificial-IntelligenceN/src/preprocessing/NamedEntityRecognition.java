package preprocessing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NamedEntityRecognition {

	private final String REGEX_WORD = "\\s*\\b[a-zA-Z]*\\b(\\.|,|'s)*\\s*";
	private final String REGEX_NUMBER = "\\s*\\b\\d\\b\\s*";
	private List<String> words;
	private List<String> numbers;

	public NamedEntityRecognition() {
		words = new ArrayList<String>();
		numbers = new ArrayList<String>();
	}

	public void recognitionWords(String text) {
		String[] s = text.split(" ");
		List<String> split = Arrays.asList(s);

		for (String w : split) {
			if (w.matches(REGEX_WORD)) {
				w = w.replaceAll("\\.|,", "");
				words.add(w);
			} else if (w.matches(REGEX_NUMBER)) {
				numbers.add(REGEX_NUMBER);
			}
		}
	}

	public List<String> getWords() {
		return words;
	}

	public List<String> getNumbers() {
		return numbers;
	}
}
