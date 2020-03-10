package com.isb.conciliator.exception;

public interface GenericException {

	public int getCode();

	public String getMessage();
	
	public String getLevel();
	
	public String getDescription();
	
}
