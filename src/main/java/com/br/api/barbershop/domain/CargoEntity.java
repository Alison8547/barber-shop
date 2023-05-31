package com.br.api.barbershop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cargo", schema = "public")
public class CargoEntity implements Serializable, GrantedAuthority {

    @Serial
    private static final long serialVersionUID = 7526502149208345058L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer idCargo;

    @Column(name = "nome")
    private String nome;

    @JsonIgnore
    @OneToMany(mappedBy = "cargo", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<ClienteEntity> clienteEntities = new HashSet<>();

    @Override
    public String getAuthority() {
        return nome;
    }
}
