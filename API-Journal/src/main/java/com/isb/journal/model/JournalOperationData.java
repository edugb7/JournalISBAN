package com.isb.journal.model;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class JournalOperationData {

	@NotNull
	private String companyCode;
	
	@NotNull
	private String instanceCode;
	
	@NotNull
	private String journalOperationType;
	
	private String externalReference;

}
