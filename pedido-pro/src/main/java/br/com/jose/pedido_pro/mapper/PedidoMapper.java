package br.com.jose.pedido_pro.mapper;

import br.com.jose.pedido_pro.dto.response.ItemPedidoResponse;
import br.com.jose.pedido_pro.dto.response.PedidoResponse;
import br.com.jose.pedido_pro.entity.Pedido;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class PedidoMapper {

    public PedidoResponse toResponseDto(Pedido pedido) {

        List<ItemPedidoResponse> itens = pedido.getItens()
                .stream()
                .map(item -> {

                    BigDecimal subtotal = item.getPrecoUnitario()
                            .multiply(BigDecimal.valueOf(item.getQuantidade()));

                    return new ItemPedidoResponse(
                            item.getId(),
                            item.getProduto().getId(),
                            item.getProduto().getNome(),
                            item.getQuantidade(),
                            item.getPrecoUnitario(),
                            subtotal
                    );
                })
                .toList();

        return new PedidoResponse(
                pedido.getId(),
                pedido.getCliente().getCpf(),
                pedido.getData(),
                pedido.getValorTotal(),
                pedido.getStatus(),
                itens
        );
    }
}