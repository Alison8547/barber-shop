package com.br.api.barbershop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cliente", schema = "public")
public class ClienteEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 7526502149208345058L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer idCliente;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email")
    private String email;

    @Column(name = "senha")
    private String senha;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "endereco")
    private String endereco;

    @Column(name = "pontos")
    private Integer pontos;

    @Column(name = "cargo_id", insertable = false, updatable = false)
    private Integer idCargo;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private CargoEntity cargo;


    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "cliente", cascade = CascadeType.ALL)
    private Set<AgendaBarberShopEntity> agendaBarberShopEntities = new LinkedHashSet<>();
}
