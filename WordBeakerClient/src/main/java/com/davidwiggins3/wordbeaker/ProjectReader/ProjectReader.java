package com.davidwiggins3.wordbeaker.ProjectReader;


public abstract class ProjectReader {

	abstract int readWordCount(String path) throws ReaderException;

}
