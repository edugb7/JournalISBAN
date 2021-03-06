package com.isb.posting.controller;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.isb.posting.exception.BadRequestError;
import com.isb.posting.entity.PostingEntity;
import com.isb.posting.exception.ErrorNotFound;
import com.isb.posting.repository.PostingRepositoryDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

@RestController
@Validated
@RequestMapping("/accounts/account_transactions")
@Api(value = "Posting microservice")
public class Controller {
	
	PostingEntity postEnt;
	
	@Autowired
	private PostingRepositoryDTO dto;
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "Creating a new posting entity", notes = "Return a new posting entity")
	@ApiResponse(response = PostingEntity.class, code = 200, message = "Succesfully creating a new posting entity")
	public PostingEntity postAccounts(
			@RequestHeader(value = "X-IBM-Client-Id", required = true) String clientId,
			@RequestHeader(value = "X-Santander-Global-Id", required = false) String santanderGlobalId,
			@RequestHeader(value = "Authorization", required = true) String authorization,
			@Valid @RequestBody(required = true) PostingEntity inputContract) {

		try {
			postEnt = dto.save(inputContract);
		} catch (DataIntegrityViolationException e) {
			throw new BadRequestError();
		}

		return postEnt;
	}
	
	@DeleteMapping("/{journalOperationId}")
	@ApiOperation(value = "Deleting a posting entity")
	@ApiResponse(response = PostingEntity.class, code = 200, message = "Succesfully deleting a posting entity")
	public void delete(
			@RequestHeader(value = "X-IBM-Client-Id", required = true) String clientId,
			@RequestHeader(value = "X-Santander-Global-Id", required = false) String santanderGlobalId,
			@RequestHeader(value = "Authorization", required = true) String authorization,
			@PathVariable(value = "journalOperationId") UUID id) {

		try {
			dto.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new ErrorNotFound();
		}
		
	}
	
}
