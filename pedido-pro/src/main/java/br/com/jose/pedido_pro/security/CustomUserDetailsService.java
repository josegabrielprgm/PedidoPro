package br.com.jose.pedido_pro.security;

import br.com.jose.pedido_pro.entity.Cliente;
import br.com.jose.pedido_pro.repository.ClienteRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final ClienteRepository repository;

    public CustomUserDetailsService(ClienteRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) {

        Cliente cliente = repository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("Cliente não encontrado"));

        return User.builder()
                .username(cliente.getEmail())
                .password(cliente.getSenha())
                .roles(cliente.getRole().name())
                .build();

    }

}
