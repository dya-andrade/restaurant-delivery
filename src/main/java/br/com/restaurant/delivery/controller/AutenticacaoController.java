package br.com.restaurant.delivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.restaurant.delivery.model.Usuario;
import br.com.restaurant.delivery.service.security.AutenticacaoService;

@RestController
@RequestMapping("/restaurante-delivery/auth")
public class AutenticacaoController {

	@Autowired
	private AutenticacaoService service;


	@PostMapping(value = "/login")
	public ResponseEntity<?> signin(@RequestBody Usuario data) {
		return service.signin(data);
	}

	@PutMapping(value = "/refresh/{email}")
	public ResponseEntity<?> refreshToken(@PathVariable("email") 
		String email, @RequestHeader("Authorization") String refreshToken) {
		return service.refreshToken(email, refreshToken);
	}
}
