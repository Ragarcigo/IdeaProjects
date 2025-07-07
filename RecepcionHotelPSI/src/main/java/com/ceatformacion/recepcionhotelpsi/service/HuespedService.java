package com.ceatformacion.recepcionhotelpsi.service;

import com.ceatformacion.recepcionhotelpsi.model.Huesped;
import com.ceatformacion.recepcionhotelpsi.repository.HuespedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HuespedService {

    @Autowired
    private HuespedRepository repository;

    public Huesped guardar(Huesped huesped) {
        return repository.save(huesped);
    }

    public List<Huesped> listarTodos() {
        return repository.findAll();
    }

    public Huesped obtenerPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
