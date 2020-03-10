package com.isb.interapplication.model;

public class ModelDataResponse {

	private String interapplicationId;
	
	private String sourceIntapp;
	
	private String targetIntapp;
	
	private String journalOperationId;
	
	private String bundle;
	
	private ModelTargetCostcenter modelTargetCostCenter;
	
	private ModelSourceCostCenter modelsourceCostCenter;
	
	private String orderText;
	
	private String movementText;
	
	private ModelOperationAmount modelOperationAmount;
	
	private String journalOperationType;
	
	private String movementCode;
	
	private String certificationMsg;

	public String getInterapplicationId() {
		return interapplicationId;
	}

	public void setInterapplicationId(String interapplicationId) {
		this.interapplicationId = interapplicationId;
	}

	public String getSourceIntapp() {
		return sourceIntapp;
	}

	public void setSourceIntapp(String sourceIntapp) {
		this.sourceIntapp = sourceIntapp;
	}

	public String getTargetIntapp() {
		return targetIntapp;
	}

	public void setTargetIntapp(String targetIntapp) {
		this.targetIntapp = targetIntapp;
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

	public ModelTargetCostcenter getModelTargetCostCenter() {
		return modelTargetCostCenter;
	}

	public void setModelTargetCostCenter(ModelTargetCostcenter modelTargetCostCenter) {
		this.modelTargetCostCenter = modelTargetCostCenter;
	}

	public ModelSourceCostCenter getModelsourceCostCenter() {
		return modelsourceCostCenter;
	}

	public void setModelsourceCostCenter(ModelSourceCostCenter modelsourceCostCenter) {
		this.modelsourceCostCenter = modelsourceCostCenter;
	}

	public String getOrderText() {
		return orderText;
	}

	public void setOrderText(String orderText) {
		this.orderText = orderText;
	}

	public String getMovementText() {
		return movementText;
	}

	public void setMovementText(String movementText) {
		this.movementText = movementText;
	}

	public ModelOperationAmount getModelOperationAmount() {
		return modelOperationAmount;
	}

	public void setModelOperationAmount(ModelOperationAmount modelOperationAmount) {
		this.modelOperationAmount = modelOperationAmount;
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

	public String getCertificationMsg() {
		return certificationMsg;
	}

	public void setCertificationMsg(String certificationMsg) {
		this.certificationMsg = certificationMsg;
	}
	
	
}
