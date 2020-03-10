package com.isb.journal.exception;

public interface GenericException {

	public int getCode();

	public String getMessage();
	
	public String getLevel();
	
	public String getDescription();
	
}
