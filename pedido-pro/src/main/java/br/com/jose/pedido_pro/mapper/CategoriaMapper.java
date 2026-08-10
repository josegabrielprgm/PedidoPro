package br.com.jose.pedido_pro.mapper;


import br.com.jose.pedido_pro.dto.request.CategoriaRequest;
import br.com.jose.pedido_pro.dto.response.CategoriaResponse;
import br.com.jose.pedido_pro.entity.Categoria;
import org.springframework.stereotype.Component;

@Component
public class CategoriaMapper {

    public Categoria toEntity(CategoriaRequest dto) {
        Categoria categoria = Categoria.builder()
                .nome(dto.nome())
                .descricao(dto.descricao())
                .build();

        categoria.setNome(dto.nome());
        categoria.setDescricao(dto.descricao());

        return categoria;
    }

    public CategoriaResponse toResponseDto(Categoria categoria) {
        return CategoriaResponse.from(categoria);
    }

}
