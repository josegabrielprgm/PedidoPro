package br.com.jose.pedido_pro.service;


import br.com.jose.pedido_pro.dto.request.ItemPedidoRequest;
import br.com.jose.pedido_pro.dto.request.PedidoRequest;
import br.com.jose.pedido_pro.dto.response.PedidoResponse;
import br.com.jose.pedido_pro.entity.Cliente;
import br.com.jose.pedido_pro.entity.ItemPedido;
import br.com.jose.pedido_pro.entity.Pedido;
import br.com.jose.pedido_pro.entity.Produto;
import br.com.jose.pedido_pro.exception.ResourceNotFoundException;
import br.com.jose.pedido_pro.mapper.PedidoMapper;
import br.com.jose.pedido_pro.repository.ClienteRepository;
import br.com.jose.pedido_pro.repository.PedidoRepository;
import br.com.jose.pedido_pro.repository.ProdutoRepository;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoService {

    private final PedidoRepository repository;
    private final PedidoMapper mapper;
    private final ProdutoRepository produtoRepository;
    private final ClienteRepository clienteRepository;

    public PedidoService(PedidoRepository repository, PedidoMapper mapper, ProdutoRepository produtoRepository, ClienteRepository clienteRepository) {
        this.repository = repository;
        this.mapper = mapper;
        this.produtoRepository = produtoRepository;
        this.clienteRepository = clienteRepository;
    }

    public PedidoResponse create(PedidoRequest dto) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        Cliente cliente = clienteRepository.findByEmail(auth.getName()).orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado"));

        Pedido pedido = new Pedido();

        pedido.setCliente(cliente);
        pedido.setData(LocalDateTime.now());
        pedido.setStatus("PENDENTE");

        List<ItemPedido> itens = new ArrayList<>();
        BigDecimal valorTotal = BigDecimal.ZERO;

        for (ItemPedidoRequest itemDto : dto.itens()) {

            Produto produto = produtoRepository.findById(itemDto.produtoId()).orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado"));

            ItemPedido item = new ItemPedido();

            item.setPedido(pedido);
            item.setProduto(produto);
            item.setQuantidade(itemDto.quantidade());
            item.setPrecoUnitario(produto.getPreco());

            itens.add(item);

            valorTotal = valorTotal.add(produto.getPreco().multiply(BigDecimal.valueOf(itemDto.quantidade())));
        }

        pedido.setItens(itens);
        pedido.setValorTotal(valorTotal);

        return mapper.toResponseDto(repository.save(pedido));
    }

    public List<PedidoResponse> getAll() {

        List<Pedido> pedidos = repository.findAll();

        return pedidos.stream().map(mapper::toResponseDto).toList();
    }

    public PedidoResponse update(Integer id, PedidoRequest dto) {

        Pedido pedido = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Pedido não encontrado"));

        List<ItemPedido> itens = new ArrayList<>();
        BigDecimal valorTotal = BigDecimal.ZERO;

        for (ItemPedidoRequest itemDto : dto.itens()) {

            Produto produto = produtoRepository.findById(itemDto.produtoId()).orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado"));

            ItemPedido item = new ItemPedido();

            item.setPedido(pedido);
            item.setProduto(produto);
            item.setQuantidade(itemDto.quantidade());
            item.setPrecoUnitario(produto.getPreco());

            itens.add(item);

            valorTotal = valorTotal.add(produto.getPreco().multiply(BigDecimal.valueOf(itemDto.quantidade())));
        }

        pedido.setItens(itens);
        pedido.setValorTotal(valorTotal);

        return mapper.toResponseDto(repository.save(pedido));
    }
}
