package br.com.jose.pedido_pro.controller;

import br.com.jose.pedido_pro.dto.request.PedidoRequest;
import br.com.jose.pedido_pro.dto.response.PedidoResponse;
import br.com.jose.pedido_pro.service.PedidoService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoService service;

    public PedidoController(PedidoService service) {
        this.service = service;
    }

    @PostMapping
    public PedidoResponse create(PedidoRequest dto) {
        return service.create(dto);
    }

    @GetMapping
    public List<PedidoResponse> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public PedidoResponse update(@Valid @PathVariable Integer id, @RequestBody PedidoRequest dto){
        return service.update(id, dto);
    }

}
