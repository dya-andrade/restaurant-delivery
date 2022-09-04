package br.com.restaurant.delivery.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.restaurant.delivery.model.usuario.PerfilAcesso;

@Repository
public interface PerfilAcessoRepository extends JpaRepository<PerfilAcesso, Long> {

	Optional<PerfilAcesso> findByDescricao(String descricao);

}
