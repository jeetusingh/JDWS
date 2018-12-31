package com.svachalitha.clientmanagement.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;

@SuppressWarnings("serial")
public class InvalidClientInfoException extends Exception {

	private HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
	private String message;
	private BindingResult result;

	public InvalidClientInfoException(HttpStatus status, String message, BindingResult result) {
		super(message);
		if (status != null) {
			this.status = status;
		}
		this.message = message;
		this.result = result;
	}

	public BindingResult getResult() {
		return result;
	}

	public HttpStatus getStatus() {
		return status;
	}

	@Override
	public String getMessage() {
		return message;
	}
}
