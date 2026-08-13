package br.com.jose.pedido_pro.service;

import br.com.jose.pedido_pro.dto.request.CategoriaRequest;
import br.com.jose.pedido_pro.dto.request.ProdutoRequest;
import br.com.jose.pedido_pro.dto.response.CategoriaResponse;
import br.com.jose.pedido_pro.dto.response.ProdutoResponse;
import br.com.jose.pedido_pro.entity.Categoria;
import br.com.jose.pedido_pro.entity.Produto;
import br.com.jose.pedido_pro.exception.DuplicateResourceException;
import br.com.jose.pedido_pro.exception.ResourceNotFoundException;
import br.com.jose.pedido_pro.mapper.ProdutoMapper;
import br.com.jose.pedido_pro.repository.CategoriaRepository;
import br.com.jose.pedido_pro.repository.ProdutoRepository;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ProdutoService {
    private final CategoriaRepository categoriaRepository;
    private final ProdutoRepository repository;
    private final ProdutoMapper mapper;

    public ProdutoService(CategoriaRepository categoriaRepository, ProdutoRepository repository, ProdutoMapper mapper) {
        this.categoriaRepository = categoriaRepository;
        this.repository = repository;
        this.mapper = mapper;
    }

    public ProdutoResponse create(ProdutoRequest dto) {

        Categoria categoria = findCategoria(dto.categoriaId());

        Produto produto = mapper.toEntity(dto, categoria);

        Produto salvo = repository.save(produto);

        return mapper.toResponseDto(salvo);

    }

    public Page<ProdutoResponse> getAll(Integer codigo, String nome, String descricao, BigDecimal preco, Boolean ativo, Pageable pageable) {
        return repository.getAll(codigo, nome, descricao, preco, ativo, pageable).map(mapper::toResponseDto);
    }

    public ProdutoResponse update(Integer id, ProdutoRequest dto) {

        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Produto não encontrado");
        }

        Produto produto = findProduto(id);

        Categoria categoria = findCategoria(dto.categoriaId());

        produto.setNome(dto.nome());
        produto.setDescricao(dto.descricao());
        produto.setPreco(dto.preco());
        produto.setEstoque(dto.estoque());
        produto.setAtivo(dto.ativo());
        produto.setCategoria(categoria);

        Produto atualizado = repository.save(produto);

        return mapper.toResponseDto(atualizado);
    }

    private Categoria findCategoria(Integer categoriaId) {
        return categoriaRepository.findById(categoriaId).orElseThrow(() -> new ResourceNotFoundException("Categoria não encontrada:" + categoriaId));
    }

    private Produto findProduto(Integer id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado: " + id));
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
