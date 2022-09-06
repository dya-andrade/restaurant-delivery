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

import br.com.restaurant.delivery.data.vo.v1.security.LoginVO;
import br.com.restaurant.delivery.service.security.AutenticacaoService;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/restaurante-delivery/login")
@Tag(name = "Login", description = "Realizar login na aplicação.")
public class LoginController {

	@Autowired
	private AutenticacaoService service;


	@PostMapping()
	public ResponseEntity<?> signin(@RequestBody LoginVO data) {
		return service.signin(data);
	}

	@PutMapping(value = "/refresh/{email}")
	public ResponseEntity<?> refreshToken(@PathVariable("email") 
		String email, @RequestHeader("Authorization") String refreshToken) {
		return service.refreshToken(email, refreshToken);
	}
}
