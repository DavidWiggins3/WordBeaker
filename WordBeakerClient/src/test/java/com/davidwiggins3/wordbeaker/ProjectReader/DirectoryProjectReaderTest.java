package com.davidwiggins3.wordbeaker.ProjectReader;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for {@link com.davidwiggins3.wordbeaker.ProjectReader.DirectoryProjectReader}.
 */
public class DirectoryProjectReaderTest extends TestCase {

	private final String testFileLoc = "TestFiles\\";	// Where all the input files for this test are found
	
	public DirectoryProjectReader reader = new DirectoryProjectReader();

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(DirectoryProjectReaderTest.class);
	}

//	/**
//	 * Reads all the supported files found in a single Directory and counts the words
//	 */
//	public void testReadDirectoryProject() {
//
//		//TODO implement me
//		
//		String fileLoc = testFileLoc;
//		int expectedNumWords = 627;	
//		try {
//			int wordCount = reader.readWordCount(fileLoc);
//			assertTrue("Wrong number of words returned from count. Expected: " + expectedNumWords, expectedNumWords == wordCount);
//		} catch (ReaderException e) {
//			e.printStackTrace();
//			fail();
//		}
//
//	}

	
//	/**
//	 * Checks that an exception is thrown when the path to a missing file is given
//	 */
//	public void testReadMissingDirectoryProject() {
//
//		String fileLoc = testFileLoc + "Bogus/";
//		try {
//			reader.readWordCount(fileLoc);
//			fail();
//		} catch (ReaderException e) {
//			assertTrue(e.getMessage().contains("(The system cannot find the path specified)"));
//		}
//
//	}

	public void test() {

		assertTrue(true);

	}
	
}
