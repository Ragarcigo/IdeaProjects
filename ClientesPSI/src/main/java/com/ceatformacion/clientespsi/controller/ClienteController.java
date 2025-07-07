package com.ceatformacion.clientespsi.controller;


import com.ceatformacion.clientespsi.model.Clientes;
import com.ceatformacion.clientespsi.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ClienteController {

    //@Autowired se encarga de crear y conectar los objetos necesarios
    @Autowired
    private ClienteRepository clienteRepository;

    //Llamar la página principal del formulario

    @GetMapping("/formulario")
    public String mostrarFormulario(Model model){
        //Le enviamos un objeto tipo cliente para que lo reciba el formulario, y a partir de alli asigne los atributos leidos
        model.addAttribute("cliente", new Clientes());
        return "formulario"; //Se llama el html de la página que quiero mostrar
    }

    //Quien recibe los datos del formulario -> la siguiente funcion que siempre debe ser PostMapping


    @PostMapping("/crud")
    public String leerFormulario(@ModelAttribute Clientes clienteFormulario, Model model){
        //Normalmente en sql.... insert into... etc...
        clienteRepository.save(clienteFormulario); //Lo guarda en la BBDD
        return "redirect:/crud";
    }

    @GetMapping("/crud")
    public String mostrarCliente(Model model){
        model.addAttribute("clienteParaCRUD", clienteRepository.findAll());
        return "crud";
    }

    @GetMapping("/editar/{id}")
    public String editar(Model model,@PathVariable int id){
        //Debemos enviar los datos del cliente que se ha consultado mediante el id, Hibernate lo busca y lo almacena en un objeto
        //recibimos el id mediante url
        //se busca en la bbdd
        //se almacena todso los datos en un objeto tipo cliente
        Clientes cliente = clienteRepository.findById(id).get(); //Busca x el id enviado por la url...
        model.addAttribute("cliente", cliente);
        return "formulario";
    }

    @GetMapping("/borrar/{id}")
    public String eliminar(Model model,@PathVariable int id){
        clienteRepository.deleteById(id);
        return "redirect:/crud";
    }
}
