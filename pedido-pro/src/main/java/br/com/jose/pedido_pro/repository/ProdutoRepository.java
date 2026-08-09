package br.com.jose.pedido_pro.repository;

import br.com.jose.pedido_pro.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
