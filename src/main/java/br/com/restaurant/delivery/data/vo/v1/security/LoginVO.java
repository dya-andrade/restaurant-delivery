package br.com.restaurant.delivery.data.vo.v1.security;

import java.io.Serializable;
import java.util.Objects;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@NotNull
public class LoginVO implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotBlank
	private String email;
	
	@NotBlank
	private String senha;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, senha);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoginVO other = (LoginVO) obj;
		return Objects.equals(email, other.email) && Objects.equals(senha, other.senha);
	}
}
