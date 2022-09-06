package br.com.restaurant.delivery.data.vo.v1.usuario;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@NotNull
public class PerfilAcessoVO implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotBlank
	private String descricao;
	

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
