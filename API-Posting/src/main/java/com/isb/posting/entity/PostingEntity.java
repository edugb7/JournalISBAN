package com.isb.posting.entity;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(value = "posting")
public class PostingEntity implements Serializable {

	private static final long serialVersionUID = -4958351786085019482L;

	@Id
	private UUID id = UUID.randomUUID();
	
	private String externalReference;

	private String bundle;

	@NotNull
	private Boolean actionCommit;

	@Valid
	private List<PostingGroup> postingGroup;

}
