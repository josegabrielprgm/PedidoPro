package br.com.jose.pedido_pro.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record PedidoRequest(

        @NotNull(message = "A data é obrigatória")
        LocalDateTime data,

        @NotEmpty(message = "O pedido deve possuir pelo menos um item")
        List<@Valid ItemPedidoRequest> itens
) {
}
