package br.com.restaurant.delivery.data.vo.v1.pedido;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.hateoas.RepresentationModel;

import br.com.restaurant.delivery.data.vo.v1.cliente.ClienteVO;
import br.com.restaurant.delivery.data.vo.v1.entrega.EntregaVO;

public class PedidoVO extends RepresentationModel<PedidoVO> implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private ClienteVO cliente;

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

	public ClienteVO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteVO cliente) {
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
}
