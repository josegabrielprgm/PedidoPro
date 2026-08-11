package br.com.jose.pedido_pro.repository;

import br.com.jose.pedido_pro.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, String> {

    Optional<Cliente> findByEmail(String email);

    Boolean existsByEmail(String email);

}
