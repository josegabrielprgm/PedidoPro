package br.com.jose.pedido_pro.repository;

import br.com.jose.pedido_pro.dto.request.CategoriaRequestDto;
import br.com.jose.pedido_pro.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

    boolean existsByNome(String nome);

    boolean existsByNomeAndIdNot(Integer id, String nome);

    Optional<Categoria> findByNome(String nome);

}
