package com.isb.posting.entity;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class OperationAmount implements Serializable {

	private static final long serialVersionUID = 1533561919877368837L;

	@NotNull
	private Double amount;
	
	@NotNull
	private String currency;

}
