package br.com.jose.pedido_pro.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "CATEGORIA")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NOME", length = 100, nullable = false, unique = true)
    private String nome;

    @Column(name = "DESCRICAO", length = 100)
    private String descricao;

    @OneToMany(mappedBy = "categoria")
    private List<Produto> produtos;

}