package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler // handles the StudentNotFoundException 404 error
	public ResponseEntity<String> handlesStudentNotFound(StudentNotFoundException ex){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	}
	@ExceptionHandler
	public ResponseEntity<String> hanlesGeral(Exception e){
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
	}
}


/* flow of how GlobalExceptionHandler work - > 
 * Request(client) > Controller > Service > studentNotFound > controllerAdvice > 
 * then handlesStudentNotFound method will return the clean 404 error */
 