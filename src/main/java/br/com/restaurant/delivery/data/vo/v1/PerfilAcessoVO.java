package br.com.restaurant.delivery.data.vo.v1;

import java.io.Serializable;
import java.util.Objects;

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

	@Override
	public int hashCode() {
		return Objects.hash(descricao);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PerfilAcessoVO other = (PerfilAcessoVO) obj;
		return Objects.equals(descricao, other.descricao);
	}
}
