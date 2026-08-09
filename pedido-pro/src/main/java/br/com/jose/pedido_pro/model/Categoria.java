package br.com.jose.pedido_pro.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "CATEGORIA")
@Getter
@Setter
@NoArgsConstructor
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