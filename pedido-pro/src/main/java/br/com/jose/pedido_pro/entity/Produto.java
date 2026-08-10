package br.com.jose.pedido_pro.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "PRODUTO")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NOME", length = 100, nullable = false)
    private String nome;

    @Column(name = "DESCRICAO", length = 200)
    private String descricao;

    @Column(name = "PRECO", precision = 10, scale = 2, nullable = false)
    private BigDecimal preco;

    @Column(name = "ESTOQUE", nullable = false)
    private Integer estoque;

    @Column(name = "ATIVO", nullable = false, columnDefinition = "TINYINT")
    private Boolean ativo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CATEGORIA_ID", nullable = false)
    private Categoria categoria;
}