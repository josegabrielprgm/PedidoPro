package br.com.jose.pedido_pro.service;

import br.com.jose.pedido_pro.dto.request.CategoriaRequest;
import br.com.jose.pedido_pro.dto.response.CategoriaResponse;
import br.com.jose.pedido_pro.mapper.CategoriaMapper;
import br.com.jose.pedido_pro.model.Categoria;
import br.com.jose.pedido_pro.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    private final CategoriaRepository repository;
    private final CategoriaMapper mapper;

    public CategoriaService(CategoriaRepository repository, CategoriaMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public CategoriaResponse create(CategoriaRequest dto) {

        if (repository.existsByNome(dto.nome())) {
            throw new RuntimeException("Já salvo no banco");
        }

        Categoria categoria = mapper.toEntity(dto);

        Categoria salva = repository.save(categoria);

        return mapper.toResponseDto(salva);
    }

    public List<CategoriaResponse> getAll(String nome, String descricao) {

        List<Categoria> categorias = repository.getAll(nome, descricao);

        return categorias.stream().map(mapper::toResponseDto).toList();
    }

    public CategoriaResponse update(Integer id, CategoriaRequest dto) {

        Categoria categoria = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada!"));

        if (repository.existsByNomeAndIdNot(dto.nome(), id)) {
            throw new RuntimeException("Já existe uma categoria com esse nome!");
        }

        categoria.setNome(dto.nome());
        categoria.setDescricao(dto.descricao());

        Categoria atualizada = repository.save(categoria);

        return mapper.toResponseDto(atualizada);
    }

    public void delete(Integer id) {

        Categoria categoria = repository.findById(id).orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
        repository.deleteById(id);

    }
}
