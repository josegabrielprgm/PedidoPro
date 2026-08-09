package br.com.jose.pedido_pro.repository;

import br.com.jose.pedido_pro.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
}
