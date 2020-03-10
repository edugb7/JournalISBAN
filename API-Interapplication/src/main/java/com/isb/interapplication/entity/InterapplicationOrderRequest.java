package com.isb.interapplication.entity;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class InterapplicationOrderRequest implements Serializable {

	private static final long serialVersionUID = 4304143952566318488L;

	@NotNull
	@ApiModelProperty(value = "The source interapplication", required = true)
	private String sourceIntapp;
	
	@NotNull
	@ApiModelProperty(value = "The target interapplication", required = true)
	private String targetIntapp;
	
	@NotNull
	@ApiModelProperty(value = "The journal operation id", required = true)
	private String journalOperationId;
	
	@NotNull
	@ApiModelProperty(value = "The bundle", required = true)
	private String bundle;
	
	private TargetCostCenter targetCostCenter;
	
	private SourceCostCenter sourceCostCenter;
	
	@NotNull
	@ApiModelProperty(value = "The order text", required = true)
	private String orderText;
	
	@NotNull
	@ApiModelProperty(value = "The movement text", required = true)
	private String movementText;
	
	@Valid
	@ApiModelProperty(value = "The oepration amount", required = true)
	private OperationAmount operationAmount;
	
	@NotNull
	@ApiModelProperty(value = "The movement code", required = true)
	private String movementCode;

}
