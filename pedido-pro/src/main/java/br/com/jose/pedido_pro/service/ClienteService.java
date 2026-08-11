package br.com.jose.pedido_pro.service;

import br.com.jose.pedido_pro.dto.request.ClienteRequest;
import br.com.jose.pedido_pro.entity.Cliente;
import br.com.jose.pedido_pro.enums.Role;
import br.com.jose.pedido_pro.exception.DuplicateResourceException;
import br.com.jose.pedido_pro.repository.ClienteRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    private final ClienteRepository repository;
    private final PasswordEncoder passwordEncoder;

    public ClienteService(ClienteRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    public Cliente create(ClienteRequest dto) {
        if (repository.existsByEmail(dto.email())) {
            throw new DuplicateResourceException("E-mail já cadastrado");
        }

        Cliente cliente = Cliente.builder()
                .cpf(dto.cpf())
                .nome(dto.nome())
                .email(dto.email())
                .telefone(dto.telefone())
                .senha(passwordEncoder.encode(dto.senha()))
                .role(Role.CLIENTE)
                .build();

        return repository.save(cliente);

    }

}
