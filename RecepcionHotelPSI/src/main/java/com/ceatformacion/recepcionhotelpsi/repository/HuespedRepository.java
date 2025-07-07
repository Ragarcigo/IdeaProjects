package com.ceatformacion.recepcionhotelpsi.repository;

import com.ceatformacion.recepcionhotelpsi.model.Huesped;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HuespedRepository extends JpaRepository<Huesped, Long> {
}
