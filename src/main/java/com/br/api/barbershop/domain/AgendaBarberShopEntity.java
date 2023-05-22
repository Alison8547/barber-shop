package com.br.api.barbershop.domain;

import com.br.api.barbershop.enums.TipoServico;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "agenda_barber_shop")
public class AgendaBarberShopEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 7526502149208345058L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idAgenda;

    @Column(name = "data_agenda")
    private LocalDateTime dataAgenda;

    @Column(name = "tipo_servico")
    @Enumerated(EnumType.ORDINAL)
    private TipoServico tipoServico;

    @Column(name = "preco")
    private Double preco;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente")
    private ClienteEntity cliente;
}
