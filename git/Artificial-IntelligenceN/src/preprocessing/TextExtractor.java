package preprocessing;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.canvas.parser.PdfTextExtractor;

public class TextExtractor {

	private RemoverStopWords remover;

	public TextExtractor() {
		remover = new RemoverStopWords();
	}

	public String extractText(String path) {
		if (path.endsWith("pdf")) {
			return extractTextFromPDF(path);
		}
		return "";
	}

	/**
	 * Extrait le texte d'un pdf et retire tous les mots "inutiles"
	 *
	 * @param path
	 *            le chemin du fichier
	 */
	public String extractTextFromPDF(String path) {
		StringBuilder text = new StringBuilder();
		try {
			PdfReader reader = new PdfReader(path);
			PdfDocument document = new PdfDocument(reader);
			for (int i = 1; i <= document.getNumberOfPages(); i++) {
				PdfPage page = document.getPage(i);
				String currentText = PdfTextExtractor.getTextFromPage(page);
				currentText = remover.remove_stop_words(currentText);
				text.append(currentText);
			}

			document.close();
			reader.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		//Mon code ajoute 
		String fileName = "documents\\" + "textExtrait.txt";
		PrintWriter pw;
		try {
			pw = new PrintWriter(fileName, "UTF-8");
			//for (int i = 0; i < dm.getWords().size(); i++) {
				pw.println(text.toString());
			//}
			pw.close();
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
		
		
		//fin de mon code ajoute

		return text.toString();
	}

}
