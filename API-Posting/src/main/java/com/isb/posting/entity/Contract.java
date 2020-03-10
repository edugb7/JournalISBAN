package com.isb.posting.entity;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class Contract implements Serializable {

	private static final long serialVersionUID = -2281098636748780846L;

	@NotNull
	private String contractId;
	
	@NotNull
	private String contractType;
	
}
