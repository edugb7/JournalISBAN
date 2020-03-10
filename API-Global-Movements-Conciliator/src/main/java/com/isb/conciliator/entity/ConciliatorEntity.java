package com.isb.conciliator.entity;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@Document(value = "movements_conciliator")
public class ConciliatorEntity implements Serializable {

	private static final long serialVersionUID = 1579984741940954470L;

	@Id
	@ApiModelProperty(value = "The journal operation's id", required = true)
	private UUID movementId = UUID.randomUUID();
	
	@NotNull
	@ApiModelProperty(value = "The movement conciliator's id", required = true)
	private String journalOperationId;
	
	private String bundle;
	
	private String serviceId;
	
	private Contract contract;
	
	@NotNull
	@ApiModelProperty(value = "The balance position", required = true)
	private String balancePosition;
	
	@NotNull
	@ApiModelProperty(value = "The operation type", required = true)
	private String operationType;
	
	@Valid
	private MovementAmount movementAmount;
	
	@NotNull
	@ApiModelProperty(value = "The movement code", required = true)
	private String movementCode;
	
	private List<CertificationMsgData> certificationMsgList;
	
}
