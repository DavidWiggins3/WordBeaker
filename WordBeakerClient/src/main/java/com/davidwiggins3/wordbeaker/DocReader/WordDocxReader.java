package com.davidwiggins3.wordbeaker.DocReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.POITextExtractor;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import com.davidwiggins3.wordbeaker.ProjectReader.ReaderException;

public class WordDocxReader extends DocReader {

	@Override
	public int readWordCount(String fileLoc) throws ReaderException {

		String extractedText = readCountableWordsFromFile(fileLoc);

		return countWords(extractedText);
	}

	/**
	 * Reads in a file at a given path and converts it's contents to a String
	 * 
	 * @param fileLoc
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private String readCountableWordsFromFile(String fileLoc) throws ReaderException {
		String extractedText = null;
		try {
			File docFile = new File(fileLoc);
			FileInputStream fis = new FileInputStream(docFile.getAbsolutePath());
			POITextExtractor extractor;

			XWPFDocument docx = new XWPFDocument(fis);
			extractor = new XWPFWordExtractor(docx);

			extractedText = extractor.getText();
		} catch (IOException e) {
			throw new ReaderException(e);
		}
		return extractedText;
	}

}
