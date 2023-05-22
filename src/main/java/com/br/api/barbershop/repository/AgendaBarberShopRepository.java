package com.br.api.barbershop.repository;

import com.br.api.barbershop.domain.AgendaBarberShopEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendaBarberShopRepository extends JpaRepository<AgendaBarberShopEntity, Long> {
}
