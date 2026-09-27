package br.com.jose.pedido_pro.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "PEDIDO")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CLIENTE_CPF", nullable = false)
    private Cliente cliente;

    @Column(name = "DATA", nullable = false)
    private LocalDateTime data;

    @Column(name = "VALOR_TOTAL", precision = 10, scale = 2)
    private BigDecimal valorTotal;

    @Column(name = "STATUS", length = 45, nullable = false)
    private String status;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemPedido> itens;

}