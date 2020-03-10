package com.isb.journal.entity.relacional;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name="operation_amount")
public class OperationAmount implements Serializable {

	private static final long serialVersionUID = -8687524072990161489L;

	@Id
	@JsonIgnore
	@Column(columnDefinition = "BINARY(16)")
	private UUID id;

	@NotNull
	private Double amount;
	
	@NotNull
	private String currency;
	
	@OneToOne
	@JoinColumn(name = "id")
	private JournalOperationRequest journalOperationRequest;

}
