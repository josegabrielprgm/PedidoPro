package br.com.jose.pedido_pro.dto.response;

import java.math.BigDecimal;

public record ProdutoResponse(
        Integer id,
        String nome,
        String descricao,
        BigDecimal preco,
        Integer estoque,
        Boolean ativo,
        CategoriaResponse categoria
) {}
