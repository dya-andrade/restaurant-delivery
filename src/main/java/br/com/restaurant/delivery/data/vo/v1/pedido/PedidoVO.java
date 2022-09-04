package br.com.restaurant.delivery.data.vo.v1.pedido;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

import javax.validation.constraints.NotNull;

@NotNull
public class PedidoVO implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotNull
	private Long idCliente;

	@NotNull
	private List<ItemPedidoVO> itensPedido;

	private BigDecimal desconto;

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public List<ItemPedidoVO> getItensPedido() {
		return itensPedido;
	}

	public void setItensPedido(List<ItemPedidoVO> itensPedido) {
		this.itensPedido = itensPedido;
	}

	public BigDecimal getDesconto() {
		return desconto;
	}

	public void setDesconto(BigDecimal desconto) {
		this.desconto = desconto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(desconto, idCliente, itensPedido);
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
		PedidoVO other = (PedidoVO) obj;
		return Objects.equals(desconto, other.desconto) && Objects.equals(idCliente, other.idCliente)
				&& Objects.equals(itensPedido, other.itensPedido);
	}
}
