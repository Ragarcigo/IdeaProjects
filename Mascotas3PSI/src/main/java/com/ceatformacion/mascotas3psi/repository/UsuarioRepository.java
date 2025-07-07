package com.ceatformacion.mascotas3psi.repository;

import com.ceatformacion.mascotas3psi.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {
    //necesitar que el repositorio busque aqui por usename
    Optional<Usuario> findByUsername(String username);

}
