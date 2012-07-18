package com.sensi.domain;

public class UserExistException extends RuntimeException {
	
	private static final long serialVersionUID = 9094876014970538340L;

	public UserExistException(String message) {
		super(message);
	}
	
	public UserExistException(String message, Throwable cause) {
		super(message, cause);
	}

}
