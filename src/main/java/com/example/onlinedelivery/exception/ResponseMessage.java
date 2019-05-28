package com.example.onlinedelivery.exception;


import java.util.Map;

import lombok.Data;

@Data
public class ResponseMessage<T> {

	private int statusCode;

	private boolean status;

	private String message;

	private Map<String, String> errors;
	
	private T body;

}

