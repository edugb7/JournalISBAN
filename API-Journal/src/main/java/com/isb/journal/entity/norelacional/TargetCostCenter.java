package com.isb.journal.entity.norelacional;

import java.io.Serializable;

import lombok.Data;

@Data
public class TargetCostCenter implements Serializable {

	private static final long serialVersionUID = -2895875322535147303L;

	private String targetCompany;
	
	private String targetCenter;
	
}
