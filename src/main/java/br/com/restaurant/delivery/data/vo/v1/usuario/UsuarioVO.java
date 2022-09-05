package br.com.restaurant.delivery.data.vo.v1.usuario;

import java.io.Serializable;
import java.util.Objects;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.hateoas.RepresentationModel;

@NotNull
public class UsuarioVO extends RepresentationModel<UsuarioVO> implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	@NotBlank
	private String email;

	@NotBlank
	private String senha;

	@NotNull
	private PerfilAcessoVO perfilAcesso;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public PerfilAcessoVO getPerfilAcesso() {
		return perfilAcesso;
	}

	public void setPerfilAcesso(PerfilAcessoVO perfilAcesso) {
		this.perfilAcesso = perfilAcesso;
	}
}
