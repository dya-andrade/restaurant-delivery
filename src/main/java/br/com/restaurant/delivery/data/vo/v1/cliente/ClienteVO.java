package br.com.restaurant.delivery.data.vo.v1.cliente;

import java.io.Serializable;
import java.util.Objects;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.restaurant.delivery.model.cliente.FormaPagamento;

@NotNull
public class ClienteVO implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotBlank
	private String nome;

	@NotBlank
	private String telefone;

	@NotNull
	private EnderecoVO endereco;

	@NotNull
	private FormaPagamento formaPagamento;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public EnderecoVO getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoVO endereco) {
		this.endereco = endereco;
	}

	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	@Override
	public int hashCode() {
		return Objects.hash(endereco, formaPagamento, nome, telefone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClienteVO other = (ClienteVO) obj;
		return Objects.equals(endereco, other.endereco) && formaPagamento == other.formaPagamento
				&& Objects.equals(nome, other.nome) && Objects.equals(telefone, other.telefone);
	}
}
