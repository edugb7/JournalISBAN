package com.isb.journal.entity.relacional;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Embeddable
@Data
public class ObbDefinitionIdentity implements Serializable {

	private static final long serialVersionUID = -2528168346952768213L;

	@Column(name = "O6B_IDINST",length = 4)
	private String instance;
	
	@Column(name = "O6B_IDEMPR",length = 4)
	private String business;
	
	@Column(name = "O6B_CODPROD",length = 3)
	private String product;
	
	@Column(name = "O6B_CODSPROD",length = 3)
	private String subtype;
	
	@Column(name = "O6B_CODOPBAS",length = 3)
	private String basic;
	
	@Column(name = "O6B_CODOPEOB",length = 3)
	private String bank;
	
	@Column(name = "O6B_FECOMVAL")
	@Temporal(TemporalType.DATE)
	private Date startDate;
	
	@Column(name = "O6B_FEFINVAL")
	@Temporal(TemporalType.DATE)
	private Date endDate;
	
}
