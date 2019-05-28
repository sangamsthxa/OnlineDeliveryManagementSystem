package com.example.onlinedelivery.model;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseObject<T> {
	private String message;

	private T body;

	private boolean error;

	@JsonIgnore
	private int statusCode = 200;

	public void setStatusCode(int code){
		RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
		HttpServletResponse response = ((ServletRequestAttributes) requestAttributes).getResponse();
		response.setStatus(statusCode);
	}

	public void setError(String message){
		setError(message,400);
	}
	public void setError(String message,int statusCode){
		setMessage(message);
		this.error = true;
		setStatusCode(statusCode);
	}


	public static class ResponseObjectBuilder<T> {

		public ResponseObjectBuilder error(String message,int statusCode) {
			message(message);
			RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
			HttpServletResponse response = ((ServletRequestAttributes) requestAttributes).getResponse();
			response.setStatus(statusCode);
			this.error = true;
			this.statusCode = statusCode;
			return this;
		}


		public ResponseObjectBuilder error(String message) {
			return error(message,400);
		}



	}
}
