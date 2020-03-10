package com.isb.journal.entity.relacional;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class ObbRelProdEqIdentity implements Serializable {

	private static final long serialVersionUID = -1766117246361762158L;

	@Column(name = "IOBPE_IDINST",length = 4)
	private String instance;
	
	@Column(name = "IOBPE_CODOPBAS",length = 3)
	private String codOpBas;
	
	@Column(name = "IOBPE_CODOPBAN",length = 3)
	private String codOpBan;

	@Column(name = "IOBPE_IDEMPREQ",length = 4)
	private String idEmprEq;
	
	@Column(name = "IOBPE_CODPROEQ",length = 3)
	private String codProEq;
	
	@Column(name = "IOBPE_CODSPREQ",length = 3)
	private String codSPrEq;
	
	@Column(name = "IOBPE_INDREL",length = 1)
	private String indrel;
	
	@Temporal(TemporalType.DATE)
	private Date feComVal;

	@Column(name = "IOBPE_USUMOD",length = 8)
	private String usuMod;
	
	@Temporal(TemporalType.DATE)
	private Date fecMod;
	
}
