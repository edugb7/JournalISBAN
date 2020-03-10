package com.isb.posting.entity;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class MovementActions implements Serializable {

	private static final long serialVersionUID = 3077820065147904120L;

	@NotNull
	private Boolean skipAuthorizationWarning;
	
	@NotNull
	private Boolean skipUnavailableBalanceAction;

	@NotNull
	private Boolean skipBlock30Days;
	
	@NotNull
	private Boolean forceExecution;
	
	@NotNull
	private String withholdingId;

}
