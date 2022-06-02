package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.exception.AddressException;
import com.example.demo.exception.CardException;
import com.example.demo.exception.CartException;
import com.example.demo.exception.CustomerException;
import com.example.demo.exception.MobileException;
import com.example.demo.exception.OrderException;
import com.example.demo.exception.PaymentException;
import com.example.demo.exception.RatingException;

@RestControllerAdvice
public class OnlineMobileShoppingApplicationControllerAdvice {
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ExceptionHandler(CustomerException.class)
	public String customerExceptionHandler(Exception e) {
		return e.getMessage();
	}

	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ExceptionHandler(MobileException.class)
	public String mobileExceptionHandler(Exception e) {
		return e.getMessage();
	}

	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ExceptionHandler(OrderException.class)
	public String orderExceptionHandler(Exception e) {
		return e.getMessage();
	}

	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ExceptionHandler(AddressException.class)
	public String addressExceptionHandler(Exception e) {
		return e.getMessage();
	}

	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ExceptionHandler(CartException.class)
	public String cartExceptionHandler(Exception e) {
		return e.getMessage();
	}

	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ExceptionHandler(CardException.class)
	public String cardExceptionHandler(Exception e) {
		return e.getMessage();
	}

	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ExceptionHandler(PaymentException.class)
	public String paymentExceptionHandler(Exception e) {
		return e.getMessage();
	}

	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ExceptionHandler(RatingException.class)
	public String ratingExceptionHandler(Exception e) {
		return e.getMessage();
	}
	
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException e) {

		Map<String, String> errorMap = new HashMap<String, String>();

		e.getBindingResult().getAllErrors().forEach((erorObject) -> {
			String fieldName = ((FieldError) erorObject).getField();
			String errorMsg = erorObject.getDefaultMessage();
			errorMap.put(fieldName, errorMsg);

		});

		return errorMap;
	}
}

