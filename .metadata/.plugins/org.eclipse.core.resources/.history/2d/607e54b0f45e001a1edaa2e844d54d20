package com.isb.posting.exception;

public class ErrorInternalServer extends RuntimeException implements GenericException {

	private static final long serialVersionUID = 5109977864109275005L;

	@Override
	public int getCode() {
		return 500;
	}

	@Override
	public String getMessage() {
		return "Internal Server Error";
	}
	
	@Override
	public String getLevel() {
		return "Error";
	}

	@Override
	public String getDescription() {
		return "The server encountred an internal error. Please retry the request.";
	}
	
}
