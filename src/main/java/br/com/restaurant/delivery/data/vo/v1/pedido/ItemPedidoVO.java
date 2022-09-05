package br.com.restaurant.delivery.data.vo.v1.pedido;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import br.com.restaurant.delivery.model.pedido.ComidaBebida;

@NotNull
public class ItemPedidoVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	
	@NotNull
	private ComidaBebida comidaBebida;
	
	@NotNull
	private Integer quantidade;
	
	private BigDecimal valorTotal;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ComidaBebida getComidaBebida() {
		return comidaBebida;
	}

	public void setComidaBebida(ComidaBebida comidaBebida) {
		this.comidaBebida = comidaBebida;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}
}
