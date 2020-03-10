package com.isb.journal.entity.norelacional;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class OperationAmount implements Serializable {

	private static final long serialVersionUID = -7551182604467488121L;

	@NotNull
	private Double amount;
	
	@NotNull
	private String currency;

}
