package br.com.restaurant.delivery.model.pedido;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.restaurant.delivery.model.cliente.Cliente;
import br.com.restaurant.delivery.model.entrega.Entrega;

@Entity
@Table(name = "pedido")
public class Pedido implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_cliente", nullable = false)
	private Cliente cliente;

	@OneToMany(targetEntity = ItemPedido.class, 
			fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<ItemPedido> itensPedido = new ArrayList<ItemPedido>();

	private LocalDateTime data;

	private BigDecimal valorTotal;

	private BigDecimal desconto;

	@ManyToOne(targetEntity = Entrega.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_entrega")
	private Entrega entrega;

	public Pedido() {}
	
	public void calculaValorTotal() {
		BigDecimal valorTotalPedido = BigDecimal.ZERO; 
		itensPedido.forEach(p -> valorTotalPedido.add(p.getValorTotal()));
		this.data = LocalDateTime.now();
	}

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

	public List<ItemPedido> getItensPedido() {
		return itensPedido;
	}

	public void setItensPedido(List<ItemPedido> itensPedido) {
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

	public Entrega getEntrega() {
		return entrega;
	}

	public void setEntrega(Entrega entrega) {
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
		Pedido other = (Pedido) obj;
		return Objects.equals(cliente, other.cliente) && Objects.equals(data, other.data)
				&& Objects.equals(desconto, other.desconto) && Objects.equals(entrega, other.entrega)
				&& Objects.equals(id, other.id) && Objects.equals(itensPedido, other.itensPedido)
				&& Objects.equals(valorTotal, other.valorTotal);
	}
}
