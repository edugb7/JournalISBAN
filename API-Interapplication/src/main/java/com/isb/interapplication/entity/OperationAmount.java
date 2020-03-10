package com.isb.interapplication.entity;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class OperationAmount implements Serializable {

	private static final long serialVersionUID = 2467128513994704445L;

	@NotNull
	private Double amount;
	
	@NotNull
	private String currency;
	
	@NotNull
	private String journalOperationType;

}
