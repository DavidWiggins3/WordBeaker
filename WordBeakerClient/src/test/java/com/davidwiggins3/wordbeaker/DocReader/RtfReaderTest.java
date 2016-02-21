package com.davidwiggins3.wordbeaker.DocReader;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.davidwiggins3.wordbeaker.ProjectReader.ReaderException;

/**
 * Unit test for {@link com.davidwiggins3.wordbeaker.DocReader.RtfReader}.
 */
public class RtfReaderTest extends TestCase {

	private final String testFileLoc = "TestFiles\\";	// Where all the input files for this test are found
	
	public RtfReader reader = new RtfReader();

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(RtfReaderTest.class);
	}

	/**
	 * Reads a single rtf file and counts the words
	 */
	public void testReadRtf() {

		String fileLoc = testFileLoc + "1.rtf";
		int expectedNumWords = 6;
		try {
			int wordCount = reader.readWordCount(fileLoc);
			assertTrue("Wrong number of words returned from count. Expected: " + expectedNumWords, expectedNumWords == wordCount);
		} catch (ReaderException e) {
			e.printStackTrace();
			fail();
		}

	}

	
	/**
	 * Checks that an exception is thrown when the path to a missing file is given
	 */
	public void testReadMissingDocx() {

		String fileLoc = testFileLoc + "Bogus.rtf";
		try {
			reader.readWordCount(fileLoc);
			fail();
		} catch (ReaderException e) {
			assertTrue(e.getMessage().contains("(The system cannot find the file specified)"));
		}

	}

}
