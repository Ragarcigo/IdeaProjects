package com.ceatformacion.registrodeusuarios.modell;

import java.time.LocalDate;

public class Usuario {
    private String nombreApellido;
    private String userName;
    private String password;
    private String email;
    static int id = 0;
    private int idUsuario = 0;
    private LocalDate fechaRegistro;

    public Usuario() {
    }

    public Usuario(int idAlumno, String nombreApellido, String userName, String password, String email, String fechaRegistro) {
        this.idUsuario=idAlumno;
        this.nombreApellido = nombreApellido;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.fechaRegistro = LocalDate.parse(fechaRegistro);
    }


    //Metodos Getter y Setter
    //Metodo temporal porque cuando usemos BBDD este id se autogenera
    public void asignarIDusuario() {
        this.idUsuario=++id;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public String getNombreApellido() {
        return nombreApellido;
    }

    public void setNombreApellido(String nombreApellido) {
        this.nombreApellido = nombreApellido;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFechaRegistro() {
        return String.valueOf(this.fechaRegistro);
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = LocalDate.parse(fechaRegistro);
    }

    @Override
    public String toString() {
        return  "ID de Usuario = " + idUsuario +
                " \nNombre y Apellidos = " + nombreApellido +
                " \nUsername = " + userName +
                " \nEmail = " + email +
                " \nPassword = " + password +
                " \nFecha de Registro = " + fechaRegistro;
    }
}
