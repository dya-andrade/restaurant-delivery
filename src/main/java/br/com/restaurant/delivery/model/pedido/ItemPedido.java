package br.com.restaurant.delivery.model.pedido;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "item_pedido")
public class ItemPedido implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.STRING)
	private ComidaBebida comidaBebida;

	private Integer quantidade;

	private BigDecimal valorTotal;

	public void calculaValorTotal() {
		BigDecimal quantidade = new BigDecimal(this.quantidade);
		BigDecimal valorTotal = comidaBebida.getValor().multiply(quantidade);
		this.valorTotal = valorTotal;
	}

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
