package com.isb.journal.model;

import lombok.Data;

@Data
public class OperationType {

	private String business;
	
	private String product;
	
	private String subProduct;
	
	private String basic;
	
	private String bank;
	
	
	public OperationType(String operationType) {
		this.business = operationType.substring(0, 4);
		this.product = operationType.substring(4, 7);
		this.subProduct = operationType.substring(7, 10);
		this.basic = operationType.substring(10, 13) ;
		this.bank = operationType.substring(13, 16) ;
	}
	
}
