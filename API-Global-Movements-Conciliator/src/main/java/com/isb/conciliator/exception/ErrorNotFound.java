package com.isb.conciliator.exception;

public class ErrorNotFound extends RuntimeException implements GenericException {

	private static final long serialVersionUID = -5127092124254241746L;
	
	@Override
	public int getCode() {
		return 404;
	}

	@Override
	public String getMessage() {
		return "Not Found";
	}
	
	@Override
	public String getLevel() {
		return "Error";
	}

	@Override
	public String getDescription() {
		return "Not exist in database or doesn`t exist response data.";
	}
	

}
