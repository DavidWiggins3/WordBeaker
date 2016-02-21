package com.davidwiggins3.wordbeaker.ProjectReader;

public class ReaderException extends Exception {

	private static final long serialVersionUID = -5460669920422994379L;

	public ReaderException(Exception e) {
		super(e);
	}

	public ReaderException(String msg) {
		super(msg);
	}

}
