package com.ceatformacion.recepcionhotelpsi.service;


import com.ceatformacion.recepcionhotelpsi.model.Reserva;
import com.ceatformacion.recepcionhotelpsi.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository repository;

    public Reserva guardar(Reserva reserva) {
        return repository.save(reserva);
    }

    public List<Reserva> listarTodos() {
        return repository.findAll();
    }

    public Reserva obtenerPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
