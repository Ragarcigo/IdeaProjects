package com.ceatformacion.clientespsi.repository;

import com.ceatformacion.clientespsi.model.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Esta interfaz conecta nuestra aplicación con la base de datos para evitar escribir manualmente sentencias SQL
 * Para indicar a que clase hace referencia este repositorio se lo tenemos que indicar entre <nombreClase, tipoWrapper de la clave principal>
 */
@Repository
public interface ClienteRepository extends JpaRepository <Clientes, Integer>{
}
