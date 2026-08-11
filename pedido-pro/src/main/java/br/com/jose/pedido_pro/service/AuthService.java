package br.com.jose.pedido_pro.service;

import br.com.jose.pedido_pro.dto.request.LoginRequest;
import br.com.jose.pedido_pro.security.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public AuthService(AuthenticationManager authenticationManager, JwtService jwtService) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    public String login(LoginRequest dto) {
        var authentication = new UsernamePasswordAuthenticationToken(dto.email(), dto.senha());

        authenticationManager.authenticate(authentication);
        String token = jwtService.generateTokemn(dto.email());
        return token;
    }
}
