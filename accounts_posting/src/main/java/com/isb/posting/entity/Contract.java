package com.isb.posting.entity;

import javax.validation.constraints.NotNull;

public class Contract {

	@NotNull
	private String contractId;
	
	@NotNull
	private String contractType;
	
	@NotNull
	private String operationId;
	
	@NotNull
	private OperationAmount operationAmount;
	
	@NotNull
	private String journalOperationId;
	
	@NotNull
	private String journalOperationType;
	
	@NotNull
	private String movementCode;
	
	private MovementActions movementActions;

	public String getContractId() {
		return contractId;
	}

	public void setContractId(String contractId) {
		this.contractId = contractId;
	}

	public String getContractType() {
		return contractType;
	}

	public void setContractType(String contractType) {
		this.contractType = contractType;
	}

	public String getOperationId() {
		return operationId;
	}

	public void setOperationId(String operationId) {
		this.operationId = operationId;
	}

	public OperationAmount getOperationAmount() {
		return operationAmount;
	}

	public void setOperationAmount(OperationAmount operationAmount) {
		this.operationAmount = operationAmount;
	}

	public String getJournalOperationId() {
		return journalOperationId;
	}

	public void setJournalOperationId(String journalOperationId) {
		this.journalOperationId = journalOperationId;
	}

	public String getJournalOperationType() {
		return journalOperationType;
	}

	public void setJournalOperationType(String journalOperationType) {
		this.journalOperationType = journalOperationType;
	}

	public String getMovementCode() {
		return movementCode;
	}

	public void setMovementCode(String movementCode) {
		this.movementCode = movementCode;
	}

	public MovementActions getMovementActions() {
		return movementActions;
	}

	public void setMovementActions(MovementActions movementActions) {
		this.movementActions = movementActions;
	}

}
