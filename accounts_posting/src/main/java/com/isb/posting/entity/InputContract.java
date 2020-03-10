package com.isb.posting.entity;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "posting")
public class InputContract implements Serializable{

	private static final long serialVersionUID = -4958351786085019482L;

	private String externalReference;

	private String bundle;

	@NotNull
	private Boolean actionCommit;

	private List<Contract> postingGroup;

	public InputContract() {
		super();
	}

	public InputContract(String externalReference, String bundle, @NotNull boolean actionCommit,
			List<Contract> postingGroup) {
		super();
		this.externalReference = externalReference;
		this.bundle = bundle;
		this.actionCommit = actionCommit;
		this.postingGroup = postingGroup;
	}

	public String getExternalReference() {
		return externalReference;
	}

	public void setExternalReference(String externalReference) {
		this.externalReference = externalReference;
	}

	public String getBundle() {
		return bundle;
	}

	public void setBundle(String bundle) {
		this.bundle = bundle;
	}

	public boolean isActionCommit() {
		return actionCommit;
	}

	public void setActionCommit(boolean actionCommit) {
		this.actionCommit = actionCommit;
	}

	public List<Contract> getPostingGroup() {
		return postingGroup;
	}

	public void setPostingGroup(List<Contract> postingGroup) {
		this.postingGroup = postingGroup;
	}

}
