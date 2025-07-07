package com.ceatformacion.registrodeusuarios.controller;

import com.ceatformacion.registrodeusuarios.modell.Usuario;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;

@Controller
public class ControllerUser {

    @GetMapping("/alta") //La ruta o la URL que utilizarás para ver el formulario...
    public String altaUsuario(Model model){
        model.addAttribute("usuario", new Usuario());
        //Mostrar en el formulario la fecha de hoy..now()
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaRegistro = LocalDate.now();
        model.addAttribute("fechaRegistro", fechaRegistro.format(formatter));
        return "Formulario"; //Envía al formulario.html
    }
    //Agregamos una colección para ir guardando los usuarios dados de alta
    ArrayList<Usuario> listausuarios = new ArrayList<>();

    @PostMapping("/guardar")
    public String guardarUsuario(@ModelAttribute Usuario usuario, Model model){
        //Asegurate de que la fecha esté correctamente configurada
        usuario.setFechaRegistro(String.valueOf(LocalDate.now()));
        usuario.asignarIDusuario();
        //Agregar el usuario a la lista
        listausuarios.add(usuario);
        //Mostrar en consola para depurar
        System.out.println(usuario);
        //Redirigir a la vista que muestra los usuarios
        return "redirect:/crud"; //Redirige a la vista de los usuarios
    }

    @GetMapping("/crud")
    public String verUsuario(Model model){
        //Pasar la lista de usuarios a la vista
        model.addAttribute("arrayDeUsuario", listausuarios);
        return "crud"; // Nombre de la vista para mostrar los usuarios
    }

    @GetMapping("/editar/{idUsuario}")
    public String modificarUsuario(@PathVariable int idUsuario, Model model){
        //Instancia de la clase donde almacenará el objeto usuario encontrado en el iterator, para pasarlo a la v
        //vista -> modificar.html
        Usuario usuarioE = null; //Iterator para recorrer el arraylist y ubicar el id que ae pasa por parámetro
        Iterator<Usuario> iterator = listausuarios.iterator();
        while(iterator.hasNext()){
            Usuario u= iterator.next();
            if(idUsuario == u.getIdUsuario()){
                usuarioE = u;
                break;
            }
        }
        if(listausuarios!=null){
            model.addAttribute("usuario", usuarioE);
            return "modificar";
        }else { //Si no lo encuentra o la lista está vacía
            return "redirect:/crud";
        }
    }

    @PostMapping("/modificar")
    public String guardarMoficacion(Model model, Usuario usuarioActualizado){
        //Recoremos el arraylist buscando el is del usuario que nos llega y luego, reemplazo todos sus datos.
        for(int i = 0; i < listausuarios.size(); i++){
            if(listausuarios.get(i).getIdUsuario() == usuarioActualizado.getIdUsuario()){
                listausuarios.set(i, usuarioActualizado); //Se reemplazan todos sus datos
                break; //Nos salimos
            }
        }
        return "redirect:/crud";
    }
    @GetMapping("/eliminar/{idUsuario}")
    public String eliminarUsuario(@PathVariable int idUsuario){
        for(int i = 0; i < listausuarios.size(); i++){
            if(listausuarios.get(i).getIdUsuario() == idUsuario){
                listausuarios.remove(i);
                break;
            }
        }
        return "redirect:/crud";
    }
}
