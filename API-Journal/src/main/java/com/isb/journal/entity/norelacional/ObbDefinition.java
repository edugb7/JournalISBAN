package com.isb.journal.entity.norelacional;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Id;

import lombok.Data;

@Data
public class ObbDefinition implements Serializable {

	private static final long serialVersionUID = 1735364321079534086L;

	@Id
	private UUID uoid = UUID.randomUUID();
	
	private String instance;

	private String business;
	
	private String product;
	
	private String subtype;
	
	private String basic;
	
	private String bank;
	
	private Date startDate;
	
	private Date endDate;
	
	private String version;
	
	private String accumulator;
	
	private String situation;

	private String technicalObject;
	
	private String indicatorBbc;
	
	private String operationType;
	
}