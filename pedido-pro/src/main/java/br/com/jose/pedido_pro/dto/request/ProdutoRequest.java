package br.com.jose.pedido_pro.dto.request;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record ProdutoRequest(@NotBlank(message = "Nome é obrigatório")
                             @Size(max = 100, message = "Nome deve ter no máximo 100 caracteres")
                             String nome,

                             @Size(max = 200, message = "Descrição deve ter no máximo 200 caracteres")
                             String descricao,

                             @NotNull(message = "Preço é obrigatório")
                             @DecimalMin(value = "0.0", inclusive = false, message = "Preço deve ser maior que zero")
                             @Digits(integer = 8, fraction = 2, message = "Preço inválido")
                             BigDecimal preco,

                             @NotNull(message = "Estoque é obrigatório")
                             @PositiveOrZero(message = "Estoque não pode ser negativo")
                             Integer estoque,

                             @NotNull(message = "Status ativo é obrigatório")
                             Boolean ativo,

                             @NotNull(message = "Categoria é obrigatória")
                             Integer categoriaId
) {}
