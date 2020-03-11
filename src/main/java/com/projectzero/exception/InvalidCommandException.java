package com.projectzero.exception;

public class InvalidCommandException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7698110219795288586L;

	public InvalidCommandException(String args) {
		super(args);
	}

	
}
