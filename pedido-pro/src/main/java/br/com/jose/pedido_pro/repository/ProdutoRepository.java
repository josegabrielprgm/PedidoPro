package br.com.jose.pedido_pro.repository;

import br.com.jose.pedido_pro.entity.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
    @Query("""
            SELECT p FROM Produto p
            WHERE (:codigo IS NULL OR p.id = :codigo)
            AND (:nome IS NULL OR p.nome LIKE %:nome%)
            AND (:descricao IS NULL OR p.descricao LIKE %:descricao%)
            AND (:preco IS NULL OR p.preco = :preco)
            AND (:ativo IS NULL OR p.ativo = :ativo)
            """)
    Page<Produto> getAll(
            @Param("codigo") Integer codigo,
            @Param("nome") String nome,
            @Param("descricao") String descricao,
            @Param("preco") BigDecimal preco,
            @Param("ativo") Boolean ativo,
            Pageable pageable
    );
}
