package com.example.demo.controllers.advice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.exceptions.NotEnoughMoneyException;
import com.example.demo.models.ErrorDetails;

@RestControllerAdvice
public class ExceptionControllerAdvice {

	@ExceptionHandler(NotEnoughMoneyException.class)
	public ResponseEntity<ErrorDetails> exceptionNotEnoughMoneyHandler(){
		ErrorDetails errorDetails = new ErrorDetails();
		errorDetails.setMessage("Not Enough Money To Make Payment");
		return ResponseEntity
				.badRequest()
				.body(errorDetails);
	}
}
