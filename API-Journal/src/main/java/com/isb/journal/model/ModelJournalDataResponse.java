package com.isb.journal.model;

import java.util.List;

import lombok.Data;

@Data
public class ModelJournalDataResponse {

	private String companyCode;
	
	private String bundle;
	
	private ModelLinks links;
	
	private List<ModelJournalOperationData> journalOperationList;

}
