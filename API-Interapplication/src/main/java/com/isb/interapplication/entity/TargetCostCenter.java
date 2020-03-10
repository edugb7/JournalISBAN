package com.isb.interapplication.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class TargetCostCenter implements Serializable {

	private static final long serialVersionUID = 1547453817909989366L;

	private String targetCompany;
	
	private String targetCenter;

}
