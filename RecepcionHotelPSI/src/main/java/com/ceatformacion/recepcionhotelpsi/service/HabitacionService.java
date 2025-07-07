package com.ceatformacion.recepcionhotelpsi.service;

import com.ceatformacion.recepcionhotelpsi.model.Habitacion;
import com.ceatformacion.recepcionhotelpsi.repository.HabitacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabitacionService {

    @Autowired
    private HabitacionRepository repository;

    public Habitacion guardar(Habitacion habitacion) {
        return repository.save(habitacion);
    }

    public List<Habitacion> listarTodos() {
        return repository.findAll();
    }

    public Habitacion obtenerPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
