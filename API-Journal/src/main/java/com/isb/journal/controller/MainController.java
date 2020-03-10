package com.isb.journal.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.isb.journal.entity.norelacional.JournalEntityMongo;
import com.isb.journal.entity.relacional.ObbDefinition;
import com.isb.journal.model.JournalOperationData;
import com.isb.journal.model.JournalOperationRequestObj;
import com.isb.journal.model.OperationType;
import com.isb.journal.repository.ObbDefinitionRepository;
import com.isb.journal.repository.RepositoryMongoDTO;

import io.swagger.annotations.Api;

@RestController
@Validated
@RequestMapping("/journal_operations")
@Api(value = "Journal microservice")
public class MainController {
	
	@Autowired
	private ObbDefinitionRepository obbRepository;
	
	@Autowired
	private RepositoryMongoDTO mongo;
	
	@PostMapping(value="/create_journal_operation", produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
//  @ApiOperation(value = "Creating a new journal entity", notes = "Return a new journal entity")
//	@ApiResponse(response = JournalEntityOracle.class, code = 200, message = "Succesfully creating a new journal entity")
	public List<ObbDefinition> createEntityOracle(
			@RequestHeader(value = "X-IBM-Client-Id", required = true) String clientId,
			@RequestHeader(value = "X-Santander-Global-Id", required = false) String santanderGlobalId,
			@RequestHeader(value = "Authorization", required = true) String authorization,
			@Valid @RequestBody JournalOperationRequestObj request) {
		
		List<ObbDefinition> obbDefinitions = new ArrayList<>();
		
		for (JournalOperationData data : request.getJournalOperationRequest().getJournalOperationList()) {
			
			OperationType opType = new OperationType(data.getJournalOperationType());
			
			ObbDefinition obbDefinition = obbRepository.findOne(opType.getBusiness(), opType.getProduct(), 
					opType.getSubProduct(), opType.getBasic(), opType.getBank());
			
			if (obbDefinition != null)
				obbDefinitions.add(obbDefinition);
		}
	
		mongo.save(new JournalEntityMongo());
		return obbDefinitions;
	}
	
}
