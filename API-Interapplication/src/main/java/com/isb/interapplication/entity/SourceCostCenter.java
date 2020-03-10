package com.isb.interapplication.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class SourceCostCenter implements Serializable {

	private static final long serialVersionUID = 6092732297279834955L;

	private String sourceCompany;
	
	private String sourceCenter;
	
}
