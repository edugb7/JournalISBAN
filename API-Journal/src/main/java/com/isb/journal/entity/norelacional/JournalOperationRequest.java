package com.isb.journal.entity.norelacional;

import java.io.Serializable;
import java.util.List;

import javax.validation.Valid;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class JournalOperationRequest implements Serializable {

	private static final long serialVersionUID = 1521088339820582884L;

	@Valid
	private List<JournalOperationData> journalOperationList;

	@Valid
	private OperationAmount operationAmount;
	
	private AccountingCostCenter accountingCostCenter;
	
	private TargetCostCenter targetCostCenter;
	
	private UserCostCenter userCostCenter;
	
	//private ObbSpecificData obbSpecificData;
	
	private String postingType;

}
