package com.ceatformacion.recepcionhotelpsi.repository;

import com.ceatformacion.recepcionhotelpsi.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
}
