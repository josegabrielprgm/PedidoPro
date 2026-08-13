package br.com.jose.pedido_pro.controller;

import br.com.jose.pedido_pro.dto.request.ProdutoRequest;
import br.com.jose.pedido_pro.dto.response.ProdutoResponse;
import br.com.jose.pedido_pro.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService service;

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    @PostMapping
    public ProdutoResponse create(@Valid @RequestBody ProdutoRequest dto) {
        return service.create(dto);
    }

    @GetMapping
    public Page<ProdutoResponse> getAll(
            @RequestParam(required = false) Integer codigo,
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) String descricao,
            @RequestParam(required = false) BigDecimal preco,
            @RequestParam(required = false) Boolean ativo,
            Pageable pageable
    ) {
        return service.getAll(codigo, nome, descricao, preco, ativo, pageable);
    }

    @PutMapping("/{id}")
    public ProdutoResponse update(
            @Valid @PathVariable Integer id,
            @RequestBody ProdutoRequest dto) {

        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }

}
