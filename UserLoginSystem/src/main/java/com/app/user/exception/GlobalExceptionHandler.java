package com.app.user.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author swapnil.mane
 *
 */


/**
 * This class is used to handle all exceptions in project
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
	

	/**
	 * This method used to handle exceptions
	 * if user already present in db
	 *
	 */
	@ExceptionHandler(UserPresentException.class)
	public ResponseEntity<ExceptionalMessage> resourceNotFoundException(UserPresentException exception) {
		String errMessage=exception.getMessage();
		return new ResponseEntity<ExceptionalMessage>(new ExceptionalMessage(errMessage,LocalDateTime.now(),false),HttpStatus.BAD_REQUEST);
	}
	

	/**
	 * This method used to handle exceptions
	 * if user is not present in db
	 *
	 */
	@ExceptionHandler(UsernameNotFoundException.class)
	public ResponseEntity<ExceptionalMessage> userNotFoundException(UsernameNotFoundException exception) {
		String errMessage=exception.getMessage();
		return new ResponseEntity<ExceptionalMessage>(new ExceptionalMessage(errMessage , LocalDateTime.now() ,false),HttpStatus.NOT_FOUND);
	}
	
	/**
	 * This method used to handle exceptions
	 * regarding validations
	 *
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String,String>>methodArgExceptions(MethodArgumentNotValidException exception){
		Map<String,String>errMap=new HashMap<>();
		exception.getBindingResult().getAllErrors().forEach(error->{
			String field = ((FieldError)error).getField();
			String defaultMessage = error.getDefaultMessage();
			errMap.put(field, defaultMessage);
		});
		return new ResponseEntity<Map<String,String>>(errMap,HttpStatus.BAD_REQUEST);
	}
	
	
	
}
