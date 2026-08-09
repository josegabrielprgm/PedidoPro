package br.com.jose.pedido_pro.service;

import br.com.jose.pedido_pro.dto.request.CategoriaRequestDto;
import br.com.jose.pedido_pro.dto.response.CategoriaResponseDto;
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

    public CategoriaResponseDto create(CategoriaRequestDto dto) {

        if (repository.existsByNome(dto.getNome())) {
            throw new RuntimeException("Já salvo no banco");
        }
        Categoria categoria = mapper.toEntity(dto);

        Categoria salva = repository.save(categoria);

        return mapper.toResponseDto(salva);
    }

    public List<CategoriaResponseDto> getAll() {

        List<Categoria> categorias = repository.findAll();

        return categorias.stream().map(mapper::toResponseDto).toList();
    }

    public CategoriaResponseDto update(Integer id, CategoriaRequestDto dto) {

        Categoria categoria = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada!"));

        if (repository.existsByNomeAndIdNot(id, dto.getNome())) {
            throw new RuntimeException("Já existe uma categoria com esse nome!");
        }

        categoria.setNome(dto.getNome());
        categoria.setDescricao(dto.getDescricao());

        Categoria atualizada = repository.save(categoria);

        return mapper.toResponseDto(atualizada);
    }

    public void delete(Integer id) {

        Categoria categoria = repository.findById(id).orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
        repository.deleteById(id);

    }
}
