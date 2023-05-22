package com.br.api.barbershop.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cargo")
public class CargoEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 7526502149208345058L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCargo;

    @Column(name = "nome")
    private String nome;
}
