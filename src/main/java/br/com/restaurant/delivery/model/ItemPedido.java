package br.com.restaurant.delivery.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Entity;
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
	
	private ComidaBebida comidaBebida;
	
	private Integer quantidade;
	
	private BigDecimal valorTotal;
	
	public ItemPedido(){}

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

	@Override
	public int hashCode() {
		return Objects.hash(comidaBebida, id, quantidade, valorTotal);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemPedido other = (ItemPedido) obj;
		return comidaBebida == other.comidaBebida && Objects.equals(id, other.id)
				&& Objects.equals(quantidade, other.quantidade) && Objects.equals(valorTotal, other.valorTotal);
	}
}
