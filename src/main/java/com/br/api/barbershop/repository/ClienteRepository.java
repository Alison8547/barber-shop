package com.br.api.barbershop.repository;

import com.br.api.barbershop.domain.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Integer> {

    Optional<ClienteEntity> findByEmail(String email);
}
