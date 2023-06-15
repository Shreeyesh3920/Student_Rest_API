package com.StudentAPP.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.StudentAPP.Payloads.ApiResponses;
@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ApiResponses> globalExceptionHandler(Exception e)
	{
		String message=e.getMessage();
		ApiResponses apiresponse=new ApiResponses(message,false);
		
		return new ResponseEntity<ApiResponses>(apiresponse,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponses> resourceNotFoundException(ResourceNotFoundException e) 
	{
		String message=e.getMessage();
		ApiResponses apiresponse=new ApiResponses(message,false);
		
		return new ResponseEntity<ApiResponses>(apiresponse,HttpStatus.BAD_REQUEST);
	}
	
	
}
