package com.davidwiggins3.wordbeaker.DocReader;

import org.apache.commons.lang3.StringUtils;

import com.davidwiggins3.wordbeaker.ProjectReader.ReaderException;

public abstract class DocReader {

	/**
	 * @param s
	 * @return The number of words in the given String s
	 */
	public int countWords(String s) {

		// compensate for weird characters found in RTF
		int wordCount = StringUtils.countMatches(s,"‘") 
				+ StringUtils.countMatches(s,"“ ") 
				+ StringUtils.countMatches(s,"“…") 
				+ StringUtils.countMatches(s,"“’ ");
		

		boolean word = false;
		int endOfLine = s.length() - 1;
		String punctutations = "\'’";

		for (int i = 0; i < s.length(); i++) {
			// if the char is a letter, word = true.
			if ((Character.isLetter(s.charAt(i)) || Character.isDigit(s.charAt(i))) && i != endOfLine) {
				word = true;
				// if char isn't a letter and there have been letters before, counter goes up.
			} else if (!Character.isLetter(s.charAt(i)) && !Character.isDigit(s.charAt(i)) && word && !punctutations.contains(""+s.charAt(i))) {
					wordCount++;
					word = false;
				// last word of String; if it doesn't end with a non letter, it wouldn't count without this.
			} else if (Character.isLetter(s.charAt(i)) && Character.isDigit(s.charAt(i)) && i == endOfLine) {
				wordCount++;
			}
		}
		return wordCount;
	}

	abstract public int readWordCount(String fileLoc) throws ReaderException;

}
