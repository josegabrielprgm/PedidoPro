package br.com.jose.pedido_pro.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record PedidoResponse(
        Integer id,
        String clienteCpf,
        LocalDateTime data,
        BigDecimal valorTotal,
        String status,
        List<ItemPedidoResponse> itens
) {}
