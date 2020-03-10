package com.isb.posting.entity;

import javax.validation.constraints.NotNull;

public class MovementActions {

	@NotNull
	private boolean skipAuthorizationWarning;
	
	@NotNull
	private boolean skipUnavailableBalanceAction;

	@NotNull
	private boolean skipBlock30Days;
	
	@NotNull
	private boolean forceExecution;
	
	@NotNull
	private String withholdingId;

	public boolean isSkipAuthorizationWarning() {
		return skipAuthorizationWarning;
	}

	public void setSkipAuthorizationWarning(boolean skipAuthorizationWarning) {
		this.skipAuthorizationWarning = skipAuthorizationWarning;
	}

	public boolean isSkipUnavailableBalanceAction() {
		return skipUnavailableBalanceAction;
	}

	public void setSkipUnavailableBalanceAction(boolean skipUnavailableBalanceAction) {
		this.skipUnavailableBalanceAction = skipUnavailableBalanceAction;
	}

	public boolean isSkipBlock30Days() {
		return skipBlock30Days;
	}

	public void setSkipBlock30Days(boolean skipBlock30Days) {
		this.skipBlock30Days = skipBlock30Days;
	}

	public boolean isForceExecution() {
		return forceExecution;
	}

	public void setForceExecution(boolean forceExecution) {
		this.forceExecution = forceExecution;
	}

	public String getWithholdingId() {
		return withholdingId;
	}

	public void setWithholdingId(String withholdingId) {
		this.withholdingId = withholdingId;
	}
	
}
