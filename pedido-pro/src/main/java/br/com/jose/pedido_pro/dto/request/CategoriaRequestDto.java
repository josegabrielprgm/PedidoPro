package br.com.jose.pedido_pro.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CategoriaRequestDto {

    private String nome;
    private String descricao;

}
