package com.isb.journal.entity.norelacional;

import java.io.Serializable;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.isb.journal.entity.norelacional.JournalOperationRequest;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Data
@Document(value = "journal")
public class JournalEntityMongo implements Serializable {

	private static final long serialVersionUID = 3633220346348558968L;

	@Id
	@ApiModelProperty(value = "The journal operation's id", required = true)
	private UUID journalOperationId = UUID.randomUUID();

	@Valid
	@ApiModelProperty(value = "The journal operation's request", required = true)
	private JournalOperationRequest journalOperationRequest;

}
