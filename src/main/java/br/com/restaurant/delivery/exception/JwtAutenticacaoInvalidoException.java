package br.com.restaurant.delivery.exception;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN) // proibido acesso
public class JwtAutenticacaoInvalidoException extends AuthenticationException {

	private static final long serialVersionUID = 1L;

	public JwtAutenticacaoInvalidoException(String ex) {
		super(ex);
	}
}
