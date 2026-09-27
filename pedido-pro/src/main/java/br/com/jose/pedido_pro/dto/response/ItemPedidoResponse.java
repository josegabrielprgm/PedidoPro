package br.com.jose.pedido_pro.dto.response;

import java.math.BigDecimal;

public record ItemPedidoResponse(
        Integer id,
        Integer produtoId,
        String produtoNome,
        Integer quantidade,
        BigDecimal precoUnitario,
        BigDecimal subtotal
) {}
