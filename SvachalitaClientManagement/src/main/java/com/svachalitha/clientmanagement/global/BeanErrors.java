package com.svachalitha.clientmanagement.global;

import java.util.Map;

import org.springframework.http.HttpStatus;

public class BeanErrors {

	private String status;
	private String message;
	private Map<String, String> errors;

	public BeanErrors(HttpStatus status, String message, Map<String, String> errors) {
		super();
		if (status != null) {
			this.status = status.toString();
		}
		this.message = message;
		this.errors = errors;
	}

	public String getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}

	public Map<String, String> getErrors() {
		return errors;
	}
}
