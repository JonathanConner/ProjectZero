package com.projectzero.exception;

public class InvalidCommandException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7698110219795288586L;

	@Override
	public String getMessage() {
		return "InvalidCommandException: An invalid command was entered please try again!";
	}
	
}
