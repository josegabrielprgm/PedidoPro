package br.com.jose.pedido_pro.mapper;

import br.com.jose.pedido_pro.dto.request.CategoriaRequest;
import br.com.jose.pedido_pro.dto.request.ProdutoRequest;
import br.com.jose.pedido_pro.dto.response.CategoriaResponse;
import br.com.jose.pedido_pro.dto.response.ProdutoResponse;
import br.com.jose.pedido_pro.entity.Categoria;
import br.com.jose.pedido_pro.entity.Produto;
import org.springframework.stereotype.Component;

@Component
public class ProdutoMapper {

    public Produto toEntity(ProdutoRequest dto, Categoria categoria) {
        return Produto.builder()
                .nome(dto.nome())
                .descricao(dto.descricao())
                .preco(dto.preco())
                .estoque(dto.estoque())
                .ativo(dto.ativo())
                .categoria(categoria)
                .build();

    }

    public ProdutoResponse toResponseDto(Produto produto) {
        return new ProdutoResponse(
                produto.getId(),
                produto.getNome(),
                produto.getDescricao(),
                produto.getPreco(),
                produto.getEstoque(),
                produto.getAtivo(),
                new CategoriaResponse(
                        produto.getCategoria().getId(),
                        produto.getCategoria().getNome(),
                        produto.getCategoria().getDescricao()
                )
        );
    }

}
