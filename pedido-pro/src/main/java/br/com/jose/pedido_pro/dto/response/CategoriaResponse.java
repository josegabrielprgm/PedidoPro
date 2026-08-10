package br.com.jose.pedido_pro.dto.response;

import br.com.jose.pedido_pro.model.Categoria;

public record CategoriaResponse(Integer id, String nome, String descricao) {

    public static CategoriaResponse from(Categoria categoria) {
        return new CategoriaResponse(categoria.getId(), categoria.getNome(), categoria.getDescricao());
    }
}
