package com.isb.interapplication.entity;

import java.io.Serializable;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Data
@Document(value = "interapplication")
public class InterapplicationEntity implements Serializable {

	private static final long serialVersionUID = 3633220346348558968L;

	@Id
	@ApiModelProperty(value = "The interapplication's id", required = true)
	private UUID interapplicationId = UUID.randomUUID();

	@Valid
	private InterapplicationOrderRequest interapplicationOrderRequest;

}
