package com.naishaairlines.exceptions;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(NoDataFoundException.class)
	public ResponseEntity<CustomizedErrorDetails> noDataFoundException(NoDataFoundException ndfe, WebRequest wr){
		CustomizedErrorDetails customizedErrorDetails = new CustomizedErrorDetails();
		customizedErrorDetails.setMessage(ndfe.getMessage());
		customizedErrorDetails.setDescription(wr.getDescription(false));
		customizedErrorDetails.setTimeStamp(LocalDateTime.now());
		return new ResponseEntity<CustomizedErrorDetails>(customizedErrorDetails, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(DuplicateDataException.class)
	public ResponseEntity<CustomizedErrorDetails> duplicateDataException(DuplicateDataException dde, WebRequest wr){
		CustomizedErrorDetails customizedErrorDetails = new CustomizedErrorDetails();
		customizedErrorDetails.setMessage(dde.getMessage());
		customizedErrorDetails.setDescription(wr.getDescription(false));
		customizedErrorDetails.setTimeStamp(LocalDateTime.now());
		return new ResponseEntity<CustomizedErrorDetails>(customizedErrorDetails, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<CustomizedErrorDetails> methodArgumentNotValidException(MethodArgumentNotValidException mnv, WebRequest wr){
		CustomizedErrorDetails customizedErrorDetails = new CustomizedErrorDetails();
		customizedErrorDetails.setTimeStamp(LocalDateTime.now());
		
		customizedErrorDetails.setMessage("Validation failed !!");
//		myErrorDetails.setDiscription("");
//		 list of all error object is here
		List<ObjectError> allErrors = mnv.getBindingResult().getAllErrors();
//		 list of all error messages is here
		List<String> errorMessages = MethodArgumentNotValidException.errorsToStringList(allErrors);
		
//		set the details here
		customizedErrorDetails.setDescription(String.join(", ", errorMessages));
		return new ResponseEntity<CustomizedErrorDetails>(customizedErrorDetails, HttpStatus.BAD_REQUEST);
	}
	
	
}
