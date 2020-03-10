package com.isb.journal.entity.norelacional;

import java.io.Serializable;

import lombok.Data;

@Data
public class UserCostCenter implements Serializable {

	private static final long serialVersionUID = -4168775477118500363L;

	private String userCompany;
	
	private String userCenter;
	
}
