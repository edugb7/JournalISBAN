package com.isb.journal.model;

import lombok.Data;

@Data
public class ModelJournalOperationData {
	
	private String journalOperationId;
	
	private String journalOperationType; 
	
	private String externalReference; 
	
	private String mainContract;   
	
	private String companyCode;    
	
	private String instanceCode;
	
	private String journalOperationStatus;
	
	private String postingType;

	private ModelOperationAmount modelOperationAmount;
	
	private ModelAccountingCostCenter journalAccountingCostcenter;
	
	private ModelTargetCostCenter modelTargetCostCenter;
	
	private ModelUserCostCenter journaluserCostCenter;
	
	private ModelObbSpecificData modelObbSpecificData;
	
}
