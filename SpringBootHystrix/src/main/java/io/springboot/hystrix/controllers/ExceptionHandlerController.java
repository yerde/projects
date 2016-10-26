package io.springboot.hystrix.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice
public class ExceptionHandlerController {
	
//	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ExceptionHandler({ NoHandlerFoundException.class})
	public ResponseEntity<Object> badRequest(HttpServletRequest req, Exception exception) {
		ResponseEntity<Object> response= new ResponseEntity<>(HttpStatus.ACCEPTED);
		return response;
	}
}
