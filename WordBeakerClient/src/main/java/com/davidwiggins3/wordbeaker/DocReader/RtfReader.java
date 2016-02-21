package com.davidwiggins3.wordbeaker.DocReader;

import java.io.FileInputStream;
import java.io.IOException;

import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.rtf.RTFEditorKit;

import com.davidwiggins3.wordbeaker.ProjectReader.ReaderException;

public class RtfReader extends DocReader {

	@Override
	public int readWordCount(String fileLoc) throws ReaderException {
		
		String extractedText = readToString(fileLoc);

		return countWords(extractedText);
	}

	private String readToString(String fileLoc) throws ReaderException {
		String extractedText = "";
		
		try {
			FileInputStream stream = new FileInputStream(fileLoc);
			RTFEditorKit kit = new RTFEditorKit();
			Document doc = kit.createDefaultDocument();
			kit.read(stream, doc, 0);
			extractedText = doc.getText(0, doc.getLength());
		} catch (BadLocationException | IOException e) {
			throw new ReaderException(e);
		}
		return extractedText;
	}

}
