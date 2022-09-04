package br.com.restaurant.delivery.data.vo.v1.cliente;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import org.springframework.hateoas.RepresentationModel;

import br.com.restaurant.delivery.data.vo.v1.pedido.PedidoCompletoVO;
import br.com.restaurant.delivery.model.cliente.FormaPagamento;

public class ClienteCompletoVO extends RepresentationModel<ClienteCompletoVO> implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String nome;

	private String telefone;

	private EnderecoVO endereco;

	private FormaPagamento formaPagamento;

	private List<PedidoCompletoVO> pedidos;

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

	public List<PedidoCompletoVO> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<PedidoCompletoVO> pedidos) {
		this.pedidos = pedidos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(endereco, formaPagamento, id, nome, pedidos, telefone);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClienteCompletoVO other = (ClienteCompletoVO) obj;
		return Objects.equals(endereco, other.endereco) && formaPagamento == other.formaPagamento
				&& Objects.equals(id, other.id) && Objects.equals(nome, other.nome)
				&& Objects.equals(pedidos, other.pedidos) && Objects.equals(telefone, other.telefone);
	}
}
