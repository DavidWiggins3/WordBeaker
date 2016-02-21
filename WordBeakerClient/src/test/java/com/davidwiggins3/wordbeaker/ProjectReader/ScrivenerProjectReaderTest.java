package com.davidwiggins3.wordbeaker.ProjectReader;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for {@link com.davidwiggins3.wordbeaker.ProjectReader.ScrivenerProjectReader}.
 */
public class ScrivenerProjectReaderTest extends TestCase {

	private final String testFileLoc = "TestFiles\\";	// Where all the input files for this test are found
	
	public ScrivenerProjectReader reader = new ScrivenerProjectReader();

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(ScrivenerProjectReaderTest.class);
	}

	/**
	 * Reads a single Scrivener Project and counts the words in the files that have been marked for inclusion in Scrivener
	 */
	public void testReadScrivenerProject() {

		//TODO Fix Me
		
		String fileLoc = testFileLoc + "Tutorial.scriv\\Tutorial.scrivx";
		int expectedNumWords = 701;
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
	public void testReadMissingScrivenerProject() {

		String fileLoc = testFileLoc + "Bogus.scriv";
		try {
			reader.readWordCount(fileLoc);
			fail();
		} catch (ReaderException e) {
			assertTrue(e.getMessage().contains("(The system cannot find the file specified)"));
		}

	}

}
