package br.com.restaurant.delivery.security.jwt;

import java.util.Base64;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import br.com.restaurant.delivery.data.vo.v1.TokenVO;
import br.com.restaurant.delivery.exception.JwtAutenticacaoInvalidoException;
import br.com.restaurant.delivery.service.security.AutorizacaoService;

@Service
public class JwtTokenProvider {

	@Value("${security.jwt.token.secret-key:secret}")
	private String secretKey = "secret";

	@Value("${security.jwt.token.expire-length:3600000}")
	private long validityInMilliseconds = 3600000; // 1h

	@Autowired
	private AutorizacaoService autorizacaoService;

	Algorithm algorithm = null;

	@PostConstruct
	protected void init() {
		secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
		algorithm = Algorithm.HMAC256(secretKey.getBytes());
	}

	public TokenVO createAccessToken(String email, List<String> roles) {
		Date now = new Date();
		Date validity = new Date(now.getTime() + validityInMilliseconds);

		String accessToken = getAccessToken(email, roles, now, validity);
		String refreshToken = getRefreshToken(email, roles, now);

		return new TokenVO(email, true, now, validity, accessToken, refreshToken);
	}

	public TokenVO refreshToken(String refreshToken) {
		if (refreshToken.contains("Bearer "))
			refreshToken = refreshToken.substring("Bearer ".length());

		JWTVerifier verifier = JWT.require(algorithm).build();
		DecodedJWT decodedJWT = verifier.verify(refreshToken);

		String email = decodedJWT.getSubject();
		List<String> roles = decodedJWT.getClaim("roles").asList(String.class);

		return createAccessToken(email, roles);
	}

	private String getAccessToken(String email, List<String> roles, Date now, Date validity) {
		String issuerUrl = ServletUriComponentsBuilder.fromCurrentContextPath().build().toString();

		return JWT.create().withClaim("roles", roles).withIssuedAt(now).withExpiresAt(validity).withSubject(email)
				.withIssuer(issuerUrl).sign(algorithm).strip();
	}

	private String getRefreshToken(String email, List<String> roles, Date now) {
		Date validityRefreshToken = new Date(now.getTime() + (validityInMilliseconds * 3));

		return JWT.create().withClaim("roles", roles).withIssuedAt(now).withExpiresAt(validityRefreshToken)
				.withSubject(email).sign(algorithm).strip();
	}

	public Authentication getAuthentication(String token) {
		DecodedJWT decodedJWT = decodedToken(token);
		UserDetails userDetails = autorizacaoService.loadUserByUsername(decodedJWT.getSubject());

		return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
	}

	private DecodedJWT decodedToken(String token) {
		Algorithm alg = Algorithm.HMAC256(secretKey.getBytes());
		JWTVerifier verifier = JWT.require(alg).build();
		DecodedJWT decodedJWT = verifier.verify(token);

		return decodedJWT;
	}

	public String resolveToken(HttpServletRequest request) {
		String bearerToken = request.getHeader("Authorization");

		if (bearerToken != null && bearerToken.startsWith("Bearer "))
			return bearerToken.substring("Bearer ".length());

		return null;
	}

	public boolean validateToken(String token) {

		DecodedJWT decodedJWT = decodedToken(token);

		try {

			if (decodedJWT.getExpiresAt().before(new Date()))
				return false;

			return true;

		} catch (Exception e) {
			throw new JwtAutenticacaoInvalidoException("Token JWT expirado ou inválido!");
		}
	}
}
