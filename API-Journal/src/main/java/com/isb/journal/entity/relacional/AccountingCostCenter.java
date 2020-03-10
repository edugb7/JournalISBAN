package com.isb.journal.entity.relacional;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name="accounting_cost_center")
public class AccountingCostCenter implements Serializable {

	private static final long serialVersionUID = 4091839459374359415L;

	@Id
	@JsonIgnore
	@Column(columnDefinition = "BINARY(16)")
	private UUID id;
	
	private String accountingCompany;
	
	private String accountingCenter;
	
	@OneToOne
	@JoinColumn(name = "id")
	private JournalOperationRequest journalOperationRequest;

}
