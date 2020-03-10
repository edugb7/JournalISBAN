package com.isb.conciliator.entity;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class MovementAmount implements Serializable {

	private static final long serialVersionUID = -5294480740648645318L;

	@NotNull
	@ApiModelProperty(value = "The amount of the movement", required = true)
	private Double amount;
	
	@NotNull
	@ApiModelProperty(value = "The currency of the movement", required = true)
	private String currency;
	
	@NotNull
	@ApiModelProperty(value = "The journal operation's type", required = true)
	private String journalOperationType;

}
