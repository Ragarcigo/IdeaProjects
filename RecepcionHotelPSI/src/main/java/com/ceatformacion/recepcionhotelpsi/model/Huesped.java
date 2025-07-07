package com.ceatformacion.recepcionhotelpsi.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "Huesped")
public class Huesped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY);
    @Column(name = "id_huesped")
    private Long id;
    private String nombre;
    private String apellido;
    private String telefono;

    @Column(name = "dni_huseped")
    private String documentoIdentidad;

    //Relación con Reserva: Un huésped puede tener muchas reservas
    @OneToMany(mappedBy = "huesped", cascade = CascadeType.ALL)
    private List<Reserva> reservas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    public void setDocumentoIdentidad(String documentoIdentidad) {
        this.documentoIdentidad = documentoIdentidad;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }
}
