package com.isb.conciliator.model;

import java.util.List;

public class ModelMovementsDataResponse {

	private String movementId;
	
	private String journalOperationId;
	
	private String bundle;
	
	private String serviceId;
	
	private ModelContract contract;
	
	private String balancePosition;
	
	private String operationType;
	
	private ModelMovementAmount movementAmount;
	
	private String journalOperationType;
	
	private String movementCode;
	
	private List<ModelCertificationMsgData> certificationMsgList;

	public String getMovementId() {
		return movementId;
	}

	public void setMovementId(String movementId) {
		this.movementId = movementId;
	}

	public String getJournalOperationId() {
		return journalOperationId;
	}

	public void setJournalOperationId(String journalOperationId) {
		this.journalOperationId = journalOperationId;
	}

	public String getBundle() {
		return bundle;
	}

	public void setBundle(String bundle) {
		this.bundle = bundle;
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public ModelContract getContract() {
		return contract;
	}

	public void setContract(ModelContract contract) {
		this.contract = contract;
	}

	public String getBalancePosition() {
		return balancePosition;
	}

	public void setBalancePosition(String balancePosition) {
		this.balancePosition = balancePosition;
	}

	public String getOperationType() {
		return operationType;
	}

	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}

	public ModelMovementAmount getMovementAmount() {
		return movementAmount;
	}

	public void setMovementAmount(ModelMovementAmount movementAmount) {
		this.movementAmount = movementAmount;
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

	public List<ModelCertificationMsgData> getCertificationMsgList() {
		return certificationMsgList;
	}

	public void setCertificationMsgList(List<ModelCertificationMsgData> certificationMsgList) {
		this.certificationMsgList = certificationMsgList;
	}
	
	
}
