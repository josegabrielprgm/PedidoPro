package br.com.jose.pedido_pro.repository;

import br.com.jose.pedido_pro.model.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Integer> {
}
