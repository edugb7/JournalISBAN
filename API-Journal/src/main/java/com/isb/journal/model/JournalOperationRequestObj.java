package com.isb.journal.model;

import javax.validation.Valid;

import lombok.Data;

@Data
public class JournalOperationRequestObj {

	@Valid
	private JournalOperationRequest journalOperationRequest;
	
}
