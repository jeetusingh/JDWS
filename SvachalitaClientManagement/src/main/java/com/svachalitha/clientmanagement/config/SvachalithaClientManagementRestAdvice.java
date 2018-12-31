package com.svachalitha.clientmanagement.config;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.svachalitha.clientmanagement.exceptions.InvalidClientInfoException;
import com.svachalitha.clientmanagement.global.BeanErrors;

@ControllerAdvice
public class SvachalithaClientManagementRestAdvice {

	@ExceptionHandler(InvalidClientInfoException.class)
	public ResponseEntity<BeanErrors> invalidClientInfoExceptionHandler(InvalidClientInfoException exception) {
		BindingResult result = exception.getResult();
		BeanErrors beanErrors = new BeanErrors(exception.getStatus(), exception.getMessage(),
				new HashMap<String, String>());
		this.buildOutput(beanErrors, result);
		return new ResponseEntity<BeanErrors>(beanErrors, HttpStatus.OK);
	}

	private void buildOutput(BeanErrors beanErrors, BindingResult result) {
		final Map<String, String> errors = beanErrors.getErrors();
		result.getFieldErrors().stream().forEach(new Consumer<FieldError>() {
			@Override
			public void accept(FieldError fieldError) {
				errors.put(fieldError.getField(), fieldError.getDefaultMessage());
			}
		});
	}
}
