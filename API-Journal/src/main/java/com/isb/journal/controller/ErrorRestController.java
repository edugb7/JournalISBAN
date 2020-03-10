package com.isb.journal.controller;

import java.net.ConnectException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.hibernate.exception.JDBCConnectionException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.isb.journal.exception.BadRequestError;
import com.isb.journal.exception.ErrorNotFound;
import com.isb.journal.exception.GenericException;

@ControllerAdvice(annotations = RestController.class)
public class ErrorRestController extends ResponseEntityExceptionHandler {

	static String code = "code";
	
	static String message = "message";
	
	static String level = "level";
	
	static String description = "description";
	
    @ExceptionHandler(value= {BadRequestError.class, ErrorNotFound.class})
    public ResponseEntity<Object> springHandleBadRequest(HttpServletResponse response, Exception e) throws InstantiationException, IllegalAccessException {
    	
    	GenericException ex = (GenericException) e.getClass().newInstance();
    	
    	Map<String, Object> body = new LinkedHashMap<>();
        
        body.put(code, ex.getCode());
        body.put(message, ex.getMessage());
        body.put(level, ex.getLevel());
        body.put(description, ex.getDescription());
    		
        return new ResponseEntity<>(body, HttpStatus.valueOf(ex.getCode()));
    }
    
    @ExceptionHandler(value= {InternalServerError.class, ConnectException.class, JDBCConnectionException.class})
    public ResponseEntity<Object> notConnection(HttpServletResponse response) throws Throwable {
    	
    	Map<String, Object> body = new LinkedHashMap<>();
        
        body.put(code, "500");
        body.put(message, "Internal Server Error");
        body.put(level, "Error");
        body.put(description, "The server encountred an internal error. Please retry the request.");

        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException e,
           HttpHeaders headers, HttpStatus status, WebRequest request) {

    	BadRequestError ex = new BadRequestError();
        Map<String, Object> body = new LinkedHashMap<>();
        
        body.put(code, ex.getCode());
        body.put(message, ex.getMessage());
        body.put(level, ex.getLevel());
        body.put(description, ex.getDescription());

        return new ResponseEntity<>(body, headers, status);

    }
}