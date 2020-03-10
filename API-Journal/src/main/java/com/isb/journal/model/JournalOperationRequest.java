package com.isb.journal.model;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class JournalOperationRequest {

	@Valid
	@Size(min = 1, max = 10)
	private List<JournalOperationData> journalOperationList;
	
}
