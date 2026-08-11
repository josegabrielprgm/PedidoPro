package br.com.jose.pedido_pro.dto.request;

public record ClienteRequest(
        String cpf,
        String nome,
        String email,
        String senha,
        String telefone
) {
}
