package br.com.jose.pedido_pro.controller;

import br.com.jose.pedido_pro.dto.request.ClienteRequest;
import br.com.jose.pedido_pro.entity.Cliente;
import br.com.jose.pedido_pro.service.ClienteService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @PostMapping
    public Cliente create(@RequestBody ClienteRequest dto) {
        return service.create(dto);
    }

}
