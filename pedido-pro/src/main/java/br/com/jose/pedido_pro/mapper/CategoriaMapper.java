package br.com.jose.pedido_pro.mapper;

import br.com.jose.pedido_pro.dto.request.CategoriaRequestDto;
import br.com.jose.pedido_pro.dto.response.CategoriaResponseDto;
import br.com.jose.pedido_pro.model.Categoria;
import org.springframework.stereotype.Component;

@Component
public class CategoriaMapper {

    public Categoria toEntity(CategoriaRequestDto dto) {
        Categoria categoria = new Categoria();

        categoria.setNome(dto.getNome());
        categoria.setDescricao(dto.getDescricao());

        return categoria;
    }

    public CategoriaResponseDto toResponseDto(Categoria categoria) {
        CategoriaResponseDto dto = new CategoriaResponseDto();

        dto.setId(categoria.getId());
        dto.setNome(categoria.getNome());
        dto.setDescricao(categoria.getDescricao());

        return dto;
    }

}
