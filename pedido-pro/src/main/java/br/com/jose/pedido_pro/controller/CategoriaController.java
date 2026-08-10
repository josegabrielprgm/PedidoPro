package br.com.jose.pedido_pro.controller;

import br.com.jose.pedido_pro.dto.request.CategoriaRequest;
import br.com.jose.pedido_pro.dto.response.CategoriaResponse;
import br.com.jose.pedido_pro.service.CategoriaService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private CategoriaService service;

    public CategoriaController(CategoriaService service) {
        this.service = service;
    }


    @PostMapping
    public CategoriaResponse create(@Valid @RequestBody CategoriaRequest categoria) {
        return service.create(categoria);
    }

    @GetMapping
    public Page<CategoriaResponse> getAll(@RequestParam(required = false) String nome, @RequestParam(required = false) String descricao, Pageable pageable) {
        return service.getAll(nome, descricao, pageable);
    }

    @PutMapping("/{id}")
    public CategoriaResponse update(@Valid @PathVariable Integer id, @RequestBody CategoriaRequest dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }

}
