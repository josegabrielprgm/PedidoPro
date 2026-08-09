package br.com.jose.pedido_pro.controller;

import br.com.jose.pedido_pro.dto.request.CategoriaRequestDto;
import br.com.jose.pedido_pro.dto.response.CategoriaResponseDto;
import br.com.jose.pedido_pro.model.Categoria;
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
    public CategoriaResponseDto create(CategoriaRequestDto categoria) {
        return service.create(categoria);
    }

    @GetMapping
    public List<CategoriaResponseDto> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public CategoriaResponseDto update(@PathVariable Integer id, @RequestBody CategoriaRequestDto dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }

}
