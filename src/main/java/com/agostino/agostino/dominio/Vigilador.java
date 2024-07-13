package com.agostino.agostino.dominio;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "vigilador")
public class Vigilador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private long legajo;
    private String nombre;
    private String apellido;

    @Column(name = "supervisor_legajo")
    private Long supervisorLegajo;

    @Column(name = "activo")
    private boolean activo = true;

    public Vigilador() {
        this.activo = true; // Establecer el valor predeterminado en el constructor
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getLegajo() {
        return legajo;
    }

    public void setLegajo(long legajo) {
        this.legajo = legajo;
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

    public Long getSupervisorLegajo() {
        return supervisorLegajo;
    }

    public void setSupervisorLegajo(Long supervisorLegajo) {
        this.supervisorLegajo = supervisorLegajo;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
