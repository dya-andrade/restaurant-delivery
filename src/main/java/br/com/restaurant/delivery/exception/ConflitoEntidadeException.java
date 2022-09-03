package br.com.restaurant.delivery.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ConflitoEntidadeException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ConflitoEntidadeException(String ex) {
		super(ex);
	}

}
