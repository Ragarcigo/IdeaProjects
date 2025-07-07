package com.ceatformacion.recepcionhotelpsi.controller;


import com.ceatformacion.recepcionhotelpsi.model.Habitacion;
import com.ceatformacion.recepcionhotelpsi.service.HabitacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/habitaciones")
public class HabitacionController {

    @Autowired
    private HabitacionService service;

    @PostMapping
    public ResponseEntity<Habitacion> crearHabitacion(@RequestBody Habitacion habitacion) {
        Habitacion creado = service.guardar(habitacion);
        return ResponseEntity.ok(creado);
    }

    @GetMapping
    public List<Habitacion> listarHabitacion() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Habitacion> obtenerHabitacion(@PathVariable Long id) {
        Habitacion habitacion = service.obtenerPorId(id);
        if (habitacion == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(habitacion);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarHabitacion(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
