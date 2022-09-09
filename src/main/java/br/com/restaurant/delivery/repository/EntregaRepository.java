package br.com.restaurant.delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.restaurant.delivery.model.entrega.Entrega;

@Repository
public interface EntregaRepository extends JpaRepository<Entrega, Long> {

	@Modifying
	@Query(value = "DELETE FROM entrega_pedidos WHERE pedidos_id = :idPedido", nativeQuery = true)
	void deletaPedidoEntrega(@Param(value = "idPedido") Long idPedido);
}
