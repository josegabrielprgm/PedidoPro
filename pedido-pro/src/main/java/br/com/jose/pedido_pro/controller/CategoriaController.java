package br.com.jose.pedido_pro.controller;

import br.com.jose.pedido_pro.dto.request.CategoriaRequest;
import br.com.jose.pedido_pro.dto.response.CategoriaResponse;
import br.com.jose.pedido_pro.service.CategoriaService;
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
    public CategoriaResponse create(@RequestBody CategoriaRequest categoria) {
        return service.create(categoria);
    }

    @GetMapping
    public List<CategoriaResponse> getAll(@RequestParam(required = false) String nome, @RequestParam(required = false) String descricao) {
        return service.getAll(nome, descricao);
    }

    @PutMapping("/{id}")
    public CategoriaResponse update(@PathVariable Integer id, @RequestBody CategoriaRequest dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }

}
