package com.ceatformacion.empleados.controller.modell;

import java.time.LocalDate;

public class Empleado {
    private static int contador;
    private String nombre;
    private String apellido;
    private int nHijos;
    private String dni;
    private LocalDate fechaNacimiento;
    private String ultimaT;
    private int idEmpleado;
    private Puesto puestoEmpleado;



    private enum Puesto{
        DIRECTOR, AGENTE, EMPLEADO;
    }

    public Empleado(String nombre, String apellido, int nHijos, String dni, String fechaNacimiento, String ultimaT, Puesto puestoEmpleado) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nHijos = nHijos;
        this.dni = dni;
        this.fechaNacimiento = LocalDate.parse(fechaNacimiento);
        this.ultimaT = ultimaT;
        this.puestoEmpleado = puestoEmpleado;
        this.idEmpleado = ++contador;
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

    public int getnHijos() {
        return nHijos;
    }

    public void setnHijos(int nHijos) {
        this.nHijos = nHijos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getUltimaT() {
        return ultimaT;
    }

    public void setUltimaT(String ultimaT) {
        this.ultimaT = ultimaT;
    }

    public Puesto getPuestoEmpleado() {
        return puestoEmpleado;
    }

    public void setPuesto(Puesto puestoEmpleado) {
        this.puestoEmpleado = puestoEmpleado;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public Empleado() {
    }
}
