package com.ceatformacion.mascotas3psi;

import com.ceatformacion.mascotas3psi.model.Usuario;
import com.ceatformacion.mascotas3psi.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class Mascotas3PsiApplication {

    public static void main(String[] args) {
        SpringApplication.run(Mascotas3PsiApplication.class, args);
    }

}