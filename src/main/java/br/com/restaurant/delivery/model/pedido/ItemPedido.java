package br.com.restaurant.delivery.model.pedido;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

	@ManyToOne(targetEntity = Pedido.class)
	@JoinColumn(name = "id_pedido", nullable = false)
	private Pedido pedido;

	public ItemPedido() {}

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

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	@Override
	public int hashCode() {
		return Objects.hash(comidaBebida, id, pedido, quantidade, valorTotal);
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
				&& Objects.equals(pedido, other.pedido) && Objects.equals(quantidade, other.quantidade)
				&& Objects.equals(valorTotal, other.valorTotal);
	}
}
