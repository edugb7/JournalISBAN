package com.isb.journal.entity.relacional;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data @Entity
@Table(name = "ob_rel_prod_eq")
public class ObbRelProdEq implements Serializable {

	private static final long serialVersionUID = -8264366602340726063L;

	@EmbeddedId
	private ObbRelProdEqIdentity obbRelProdEqIdentity;
	
	@Column(name = "IOBPE_IDEMPR",length = 4)
	private String idEmpr;

	@Column(name = "IOBPE_CODPROD",length = 3)
	private String codProd;
	
	@Column(name = "IOBPE_CODSPROD",length = 3)
	private String codSProd;
	
	@Temporal(TemporalType.DATE)
	private Date feFinVal;
	
	
}
