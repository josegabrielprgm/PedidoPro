package br.com.jose.pedido_pro.repository;

import br.com.jose.pedido_pro.entity.Categoria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

    boolean existsByNome(String nome);

    boolean existsByNomeAndIdNot(String nome, Integer id);

    Optional<Categoria> findByNome(String nome);

    @Query("""
                SELECT o FROM Categoria o
                WHERE (:nome IS NULL OR o.nome LIKE %:nome%)
                AND (:descricao IS NULL OR o.descricao LIKE %:descricao%)
            """)
    List<Categoria> getAll(
            @Param("nome") String nome,
            @Param("descricao") String descricao
    );

    Page<Categoria> findByNomeContainingIgnoreCaseAndDescricaoContainingIgnoreCase(
            String nome,
            String descricao,
            Pageable pageable
    );
}
