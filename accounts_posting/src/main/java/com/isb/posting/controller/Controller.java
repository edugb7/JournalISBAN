package com.isb.posting.controller;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.isb.posting.entity.InputContract;
import com.isb.posting.service.PostingService;

@RestController
@Validated
@RequestMapping("/accounts/account_transactions")
public class Controller {
	
	@Autowired
	private PostingService dto;
	
	@PostMapping()
	@ResponseStatus(value = HttpStatus.OK)
	public InputContract postAccounts(
			@RequestHeader(value = "X-IBM-Client-Id", required = true) String clientId,
			@RequestHeader(value = "X-Santander-Global-Id", required = false) String santanderGlobalId,
			@RequestHeader(value = "Authorization", required = true) String authorization,
			@Valid @RequestBody(required = true) InputContract inputContract) {
		
		return dto.save(inputContract);
	}
	
	@DeleteMapping("/{journalOperationId}")
	public ResponseEntity<Object> delete(
			@RequestHeader(value = "X-IBM-Client-Id", required = true) String clientId,
			@RequestHeader(value = "X-Santander-Global-Id", required = false) String santanderGlobalId,
			@RequestHeader(value = "Authorization", required = true) String authorization,
			@PathParam(value = "journalOperationId") Integer id) {
		return new ResponseEntity<>("", HttpStatus.OK);
	}
	
}
