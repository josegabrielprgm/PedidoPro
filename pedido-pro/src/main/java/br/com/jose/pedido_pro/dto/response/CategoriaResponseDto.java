package br.com.jose.pedido_pro.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CategoriaResponseDto {

    private Integer id;
    private String nome;
    private String descricao;

}
