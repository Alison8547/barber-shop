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
@Table(name = "cliente")
public class ClienteEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 7526502149208345058L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCliente;

    @Column(name = "email")
    private String email;

    @Column(name = "senha")
    private String senha;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cargo")
    private CargoEntity cargo;


    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "cliente", cascade = CascadeType.ALL)
    private Set<AgendaBarberShopEntity> agendaBarberShopEntities = new LinkedHashSet<>();
}
