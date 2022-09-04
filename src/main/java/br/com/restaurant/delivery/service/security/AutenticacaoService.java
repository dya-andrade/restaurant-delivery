package br.com.restaurant.delivery.service.security;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.restaurant.delivery.data.vo.v1.security.LoginVO;
import br.com.restaurant.delivery.data.vo.v1.security.TokenVO;
import br.com.restaurant.delivery.model.usuario.Usuario;
import br.com.restaurant.delivery.repository.UsuarioRepository;
import br.com.restaurant.delivery.security.jwt.JwtTokenProvider;

@Service
public class AutenticacaoService {
	
	@Autowired
	private AuthenticationManager authManager;

	@Autowired
	private JwtTokenProvider tokenProvider;

	@Autowired
	private UsuarioRepository repository;
	

	public ResponseEntity<?> signin(LoginVO data) {

		if (checkIfParamsIsNotNull(data))
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Solicitação de usuário inválida!");

		TokenVO tokenResponse = new TokenVO();

		try {

			String email = data.getEmail();
			String senha = data.getSenha();
			
			UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(email, senha);
			authManager.authenticate(authentication);

			Optional<Usuario> user = repository.findByEmail(email);

			if (user.isPresent()) {
				tokenResponse = tokenProvider.createAccessToken(email, Arrays.asList(user.get().getRole()));
			} else {
				throw new UsernameNotFoundException("Email " + email + " não encontrado!");
			}

		} catch (Exception e) {
			throw new BadCredentialsException("Email ou senha inválidos!");
		}

		if (tokenResponse == null)
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Solicitação de usuário inválida!");
		else
			return ResponseEntity.ok(tokenResponse);
	}

	public ResponseEntity<?> refreshToken(String email, String refreshToken) {

		if (checkIfParamsIsNotNull(email, refreshToken))
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Solicitação de usuário inválida!");

		Optional<Usuario> user = repository.findByEmail(email);

		TokenVO tokenResponse = new TokenVO();

		if (user.isPresent()) {
			tokenResponse = tokenProvider.refreshToken(refreshToken);
		} else {
			throw new UsernameNotFoundException("Usuário " + email + " não encontrado!");
		}

		if(tokenResponse == null)
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Solicitação de usuário inválida!");
		else
			return ResponseEntity.ok(tokenResponse);
	}

	private boolean checkIfParamsIsNotNull(String email, String refreshToken) {
		return refreshToken == null || refreshToken.isBlank() || email == null || email.isBlank();
	}

	private boolean checkIfParamsIsNotNull(LoginVO data) {
		return data == null || data.getEmail() == null || data.getEmail().isBlank() || data.getSenha() == null
				|| data.getSenha().isBlank();
	}
}
