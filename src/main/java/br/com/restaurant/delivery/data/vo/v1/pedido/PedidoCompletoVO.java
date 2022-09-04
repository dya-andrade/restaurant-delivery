package br.com.restaurant.delivery.data.vo.v1.pedido;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import org.springframework.hateoas.RepresentationModel;

import br.com.restaurant.delivery.data.vo.v1.entrega.EntregaVO;
import br.com.restaurant.delivery.model.cliente.Cliente;
import br.com.restaurant.delivery.model.entrega.Entrega;

public class PedidoCompletoVO extends RepresentationModel<PedidoCompletoVO> implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private Cliente cliente;

	private List<ItemPedidoVO> itensPedido;

	private LocalDateTime data;

	private BigDecimal valorTotal;

	private BigDecimal desconto;

	private EntregaVO entrega;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<ItemPedidoVO> getItensPedido() {
		return itensPedido;
	}

	public void setItensPedido(List<ItemPedidoVO> itensPedido) {
		this.itensPedido = itensPedido;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public BigDecimal getDesconto() {
		return desconto;
	}

	public void setDesconto(BigDecimal desconto) {
		this.desconto = desconto;
	}

	public EntregaVO getEntrega() {
		return entrega;
	}

	public void setEntrega(EntregaVO entrega) {
		this.entrega = entrega;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cliente, data, desconto, entrega, id, itensPedido, valorTotal);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PedidoCompletoVO other = (PedidoCompletoVO) obj;
		return Objects.equals(cliente, other.cliente) && Objects.equals(data, other.data)
				&& Objects.equals(desconto, other.desconto) && Objects.equals(entrega, other.entrega)
				&& Objects.equals(id, other.id) && Objects.equals(itensPedido, other.itensPedido)
				&& Objects.equals(valorTotal, other.valorTotal);
	}
}
