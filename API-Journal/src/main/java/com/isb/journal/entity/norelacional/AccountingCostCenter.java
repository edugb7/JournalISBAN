package com.isb.journal.entity.norelacional;

import java.io.Serializable;

import lombok.Data;

@Data
public class AccountingCostCenter implements Serializable {

	private static final long serialVersionUID = -5324636318518007938L;

	private String accountingCompany;
	
	private String accountingCenter;
	
}
