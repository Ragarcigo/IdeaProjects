package com.ceatformacion.recepcionhotelpsi.controller;


import com.ceatformacion.recepcionhotelpsi.model.Huesped;
import com.ceatformacion.recepcionhotelpsi.service.HuespedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/huespedes")
public class HuespedController {

    @Autowired
    private HuespedService service;

    @PostMapping
    public ResponseEntity<Huesped> crearHuesped(@RequestBody Huesped huesped) {
        Huesped creado = service.guardar(huesped);
        return ResponseEntity.ok(creado);
    }

    @GetMapping
    public List<Huesped> listarHuesped(){
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Huesped> obtenerHuesped(@PathVariable Long id){
        Huesped huesped = service.obtenerPorId(id);
        if(huesped == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(huesped);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarHuesped(@PathVariable Long id){
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
