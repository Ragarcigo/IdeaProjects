package com.ceatformacion.empleados.controller;


import com.ceatformacion.empleados.controller.modell.Empleado;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;

@Controller
public class EmpleadosController {
    private static final ArrayList<Empleado> empleados = new ArrayList<>();


    @GetMapping("/")//Llama el archivo que esta función nombra con lo indicado en el paréntesis que le sigue
    public String llamarIndex(Model model){
        model.addAttribute("empleado", new Empleado());
        model.addAttribute("puestos",Empleado.Puesto.values());
        return "index"; //Llama el archivo de la vista con nombre index, y muestralo...
    }

    @GetMapping("/empleados/alta")
    public String guardarEmpleado(@ModelAttribute Empleado empleado, Model model){
        //Agregar ese empleado a una coleccion
        empleados.add(empleado);
        model.addAttribute("empleado", empleado);
        return ("crud");
    }



}
