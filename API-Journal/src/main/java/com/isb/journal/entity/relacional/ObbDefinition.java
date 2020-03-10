package com.isb.journal.entity.relacional;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data @Entity
@Table(name = "obb_definition")
public class ObbDefinition implements Serializable {

	private static final long serialVersionUID = -7683451934294222868L;

	@EmbeddedId
	private ObbDefinitionIdentity obbDefinitionIdentity;
	
	@Column(name = "O6B_VERSOPER", precision = 5, scale = 0)
	private String version;
	
	@Column(name = "ACU02_IDACUMUL",length = 3)
	private String accumulator;
	
	@Column(name = "O6B_SITUACI",length = 1)
	private String situation;

	@Column(name = "O6B_NROFX",length = 6)
	private String technicalObject;
	
	@Column(name = "O6B_INDACURA",length = 1)
	private String indicatorBbc;
	
	@Column(name = "O4B_CLSOPERB",length = 2)
	private String operationType;
	
}
