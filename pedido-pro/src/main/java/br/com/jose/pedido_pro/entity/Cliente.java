package br.com.jose.pedido_pro.entity;

import br.com.jose.pedido_pro.enums.Role;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "CLIENTE")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "cpf")
public class Cliente {

    @Id
    @Column(name = "CPF", length = 11, nullable = false)
    private String cpf;

    @Column(name = "NOME", length = 100, nullable = false)
    private String nome;

    @Column(name = "EMAIL", length = 100)
    private String email;

    @Column(name = "SENHA")
    private String senha;

    @Column(name = "TELEFONE", length = 11, nullable = false)
    private String telefone;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Pedido> pedidos;

    @Enumerated(EnumType.STRING)
    @Column(name = "ROLE", nullable = false)
    private Role role;
}
