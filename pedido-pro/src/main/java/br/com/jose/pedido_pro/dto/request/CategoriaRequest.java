package br.com.jose.pedido_pro.dto.request;


import jakarta.validation.constraints.NotNull;

public record CategoriaRequest(@NotNull String nome, String descricao) {
}
