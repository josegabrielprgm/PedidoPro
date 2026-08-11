package br.com.jose.pedido_pro.controller;

import br.com.jose.pedido_pro.dto.request.LoginRequest;
import br.com.jose.pedido_pro.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService service;

    public AuthController(AuthService service) {
        this.service = service;
    }

    @PostMapping("/login")
    public ResponseEntity<String> Login(@RequestBody LoginRequest dto) {
        String token = service.login(dto);

        return ResponseEntity.ok(token);
    }

}
