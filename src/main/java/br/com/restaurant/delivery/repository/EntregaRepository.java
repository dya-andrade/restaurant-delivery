package br.com.restaurant.delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.restaurant.delivery.model.entrega.Entrega;

@Repository
public interface EntregaRepository extends JpaRepository<Entrega, Long> {

}
