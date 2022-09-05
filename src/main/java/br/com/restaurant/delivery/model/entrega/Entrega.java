package br.com.restaurant.delivery.model.entrega;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.restaurant.delivery.model.pedido.Pedido;

@Entity
@Table(name = "entrega")
public class Entrega implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private LocalDateTime data;
	
	private String motoboy;
	
	private LocalDateTime valor;
	
    @OneToMany(targetEntity = Pedido.class)
    private List<Pedido> pedidos = new ArrayList<Pedido>();
    
    public Entrega() {}
    
    public void adicionaPedidos(List<Pedido> pedidos) {
    	this.pedidos = pedidos;
    	this.data = LocalDateTime.now();
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public String getMotoboy() {
		return motoboy;
	}

	public void setMotoboy(String motoboy) {
		this.motoboy = motoboy;
	}

	public LocalDateTime getValor() {
		return valor;
	}

	public void setValor(LocalDateTime valor) {
		this.valor = valor;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(data, id, motoboy, pedidos, valor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entrega other = (Entrega) obj;
		return Objects.equals(data, other.data) && Objects.equals(id, other.id)
				&& Objects.equals(motoboy, other.motoboy) && Objects.equals(pedidos, other.pedidos)
				&& Objects.equals(valor, other.valor);
	}
}
