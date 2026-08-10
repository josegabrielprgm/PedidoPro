package br.com.jose.pedido_pro.repository;

import br.com.jose.pedido_pro.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, String> {
}
