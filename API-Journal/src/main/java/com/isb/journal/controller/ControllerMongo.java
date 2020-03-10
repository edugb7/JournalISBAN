package com.isb.journal.controller;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.isb.journal.entity.norelacional.JournalEntityMongo;
import com.isb.journal.exception.BadRequestError;
import com.isb.journal.exception.ErrorNotFound;
import com.isb.journal.repository.RepositoryMongoDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

@RestController()
@Validated
@RequestMapping("/journal_operations/mongo")
@Api(value = "Journal microservice")
public class ControllerMongo {

	JournalEntityMongo jourEnt;
	
	@Autowired
	private RepositoryMongoDTO dto;
	
	@PostMapping(value="/create_journal_operation", produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Creating a new journal entity", notes = "Return a new journal entity")
	@ApiResponse(response = JournalEntityMongo.class, code = 200, message = "Succesfully creating a new journal entity")
	public JournalEntityMongo createEntityMongo(
			@RequestHeader(value = "X-IBM-Client-Id", required = true) String clientId,
			@RequestHeader(value = "X-Santander-Global-Id", required = false) String santanderGlobalId,
			@RequestHeader(value = "Authorization", required = true) String authorization,
			@Valid @RequestBody JournalEntityMongo journalEntityMongo) {

		try {
			jourEnt = dto.save(journalEntityMongo);
		} catch (DataIntegrityViolationException e) {
			throw new BadRequestError();
		}
		
		return jourEnt;
	}
	
	@PutMapping(value="/{journal_operation_id}")
	@ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Update a journal entity", notes = "Update a journal entity by Id")
	@ApiResponse(response = JournalEntityMongo.class, code = 200, message = "Succesfully updating a journal entity")
	public JournalEntityMongo modidfyEntityMongo(
			@RequestHeader(value = "X-IBM-Client-Id", required = true) String clientId,
			@RequestHeader(value = "X-Santander-Global-Id", required = false) String santanderGlobalId,
			@RequestHeader(value = "Authorization", required = true) String authorization,
			@PathVariable("journal_operation_id") UUID id, 
			@Valid @RequestBody JournalEntityMongo journalEntityMongo) {

		journalEntityMongo.setJournalOperationId(id);

		try {
			jourEnt = dto.save(journalEntityMongo);
		} catch (DataIntegrityViolationException e) {
			throw new BadRequestError();
		}
		
		return jourEnt;

	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Find all entities", notes = "Return all journal entities")
	@ApiResponse(code = 200, message = "Succesfully getting all journal entities")
	public ResponseEntity<Object> getAllByMongo() {
		
		List<JournalEntityMongo> listJournal;
		
		try {
			listJournal = dto.findAll();
		} catch (DataIntegrityViolationException e) {
			throw new ErrorNotFound();
		}
		 
        return new ResponseEntity<>(listJournal, HttpStatus.OK);  
	}
    
	@GetMapping(path="/{journal_operation_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Find an journal entity", notes = "Return a journal entity by Id")
	@ApiResponse(code = 200, message = "Succesfully getting a journal entitiy by Id")
	public ResponseEntity<Object> getByIdByMongo(@PathVariable(value="journal_operation_id") UUID id) {
		
		try {
			jourEnt = dto.findById(id).orElse(null);
		} catch (DataIntegrityViolationException e) {
			throw new ErrorNotFound();
		}

        return new ResponseEntity<>(jourEnt, HttpStatus.OK); 

	}

}
