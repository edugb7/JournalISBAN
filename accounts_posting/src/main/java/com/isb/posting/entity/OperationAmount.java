package com.isb.posting.entity;

import javax.validation.constraints.NotNull;

public class OperationAmount {

	@NotNull
	private Double amount;
	
	@NotNull
	private String currency;

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	
}
