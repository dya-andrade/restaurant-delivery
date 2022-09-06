package br.com.restaurant.delivery.data.vo.v1.cliente;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.hateoas.RepresentationModel;

import br.com.restaurant.delivery.model.cliente.FormaPagamento;

@NotNull
public class ClienteVO extends RepresentationModel<ClienteVO> implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	@NotBlank
	private String nome;

	@NotBlank
	private String telefone;

	@NotNull
	private EnderecoVO endereco;

	@NotNull
	private FormaPagamento formaPagamento;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
}
