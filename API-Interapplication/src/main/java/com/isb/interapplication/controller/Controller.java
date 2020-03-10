package com.isb.interapplication.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.isb.interapplication.exception.BadRequestError;
import com.isb.interapplication.entity.InterapplicationEntity;
import com.isb.interapplication.repository.InterapplicationRepositoryDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

@RestController()
@Validated
@RequestMapping("/interapplication/")
@Api(value = "Interapplication microservice")
public class Controller {

	@Autowired
	private InterapplicationRepositoryDTO dto;
	
	InterapplicationEntity interEntity;
	
	@PostMapping(value="/create_order", produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Creating a new interapplication operation", notes = "Return a new interapplication operation")
	@ApiResponse(response = InterapplicationEntity.class, code = 200, message = "Succesfully creating a new interapplication operation")
	public InterapplicationEntity createInterapplicationOperation(
			@RequestHeader(value = "X-IBM-Client-Id", required = true) String clientId,
			@RequestHeader(value = "X-Santander-Global-Id", required = false) String santanderGlobalId,
			@RequestHeader(value = "Authorization", required = true) String authorization,
			@Valid @RequestBody InterapplicationEntity interappEntity) {

		try {
			interEntity = dto.save(interappEntity);
		} catch (DataIntegrityViolationException e) {
			throw new BadRequestError();
		}
		
		return interEntity;
	}
}
