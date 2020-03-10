package com.isb.posting.exception;

public class BadRequestError extends RuntimeException implements GenericException {

	private static final long serialVersionUID = -3870904263986084772L;

	@Override
	public int getCode() {
		return 400;
	}

	@Override
	public String getMessage() {
		return "Bad Request";
	}
	
	@Override
	public String getLevel() {
		return "Error";
	}

	@Override
	public String getDescription() {
		return "Input data are erroneus or no specified.";
	}
	
}
