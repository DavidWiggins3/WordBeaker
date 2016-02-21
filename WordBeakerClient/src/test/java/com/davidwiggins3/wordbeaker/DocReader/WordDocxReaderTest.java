package com.davidwiggins3.wordbeaker.DocReader;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.davidwiggins3.wordbeaker.ProjectReader.ReaderException;

/**
 * Unit test for {@link com.davidwiggins3.wordbeaker.DocReader.WordDocxReader}.
 */
public class WordDocxReaderTest extends TestCase {

	private final String testFileLoc = "TestFiles\\";	// Where all the input files for this test are found
	
	public WordDocxReader reader = new WordDocxReader();

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(WordDocxReaderTest.class);
	}

	/**
	 * Reads a single Docx file and counts the words
	 */
	public void testReadDocx() {

		String fileLoc = testFileLoc + "1.docx";
		int expectedNumWords = 6;
		try {
			int wordCount = reader.readWordCount(fileLoc);
			assertTrue("Wrong number of words returned from count. Expected: " + expectedNumWords + " found: " + wordCount, expectedNumWords == wordCount);
		} catch (ReaderException e) {
			e.printStackTrace();
			fail();
		}

	}

	
	/**
	 * Checks that an exception is thrown when the path to a missing file is given
	 */
	public void testReadMissingDocx() {

		String fileLoc = testFileLoc + "Bogus.docx";
		try {
			reader.readWordCount(fileLoc);
			fail();
		} catch (ReaderException e) {
			assertTrue(e.getMessage().contains("(The system cannot find the file specified)"));
		}

	}

}
