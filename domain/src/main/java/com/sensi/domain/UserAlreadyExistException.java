package com.sensi.domain;

public class UserAlreadyExistException extends RuntimeException {
	
	private static final long serialVersionUID = 9094876014970538340L;

	public UserAlreadyExistException(String message) {
		super(message);
	}
	
	public UserAlreadyExistException(String message, Throwable cause) {
		super(message, cause);
	}

}
