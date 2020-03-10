package com.isb.journal.entity.relacional;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name="journal_operation_data")
public class JournalOperationData implements Serializable {

	private static final long serialVersionUID = 6597401255691969352L;

	@Id
	@JsonIgnore
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	private String companyCode;
	
	@NotNull
	private String instanceCode;
	
	@NotNull
	private String journalOperationType;
	
	private String externalReference;

	private String mainContract;

}
