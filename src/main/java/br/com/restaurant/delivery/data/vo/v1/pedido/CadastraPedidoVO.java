package br.com.restaurant.delivery.data.vo.v1.pedido;

import java.math.BigDecimal;
import java.util.List;

public class CadastraPedidoVO {
	
	private List<ItemPedidoVO> itensPedido;

	private Long idCliente;

	private BigDecimal desconto;

	public List<ItemPedidoVO> getItensPedido() {
		return itensPedido;
	}

	public void setItensPedido(List<ItemPedidoVO> itensPedido) {
		this.itensPedido = itensPedido;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public BigDecimal getDesconto() {
		return desconto;
	}

	public void setDesconto(BigDecimal desconto) {
		this.desconto = desconto;
	}
}
