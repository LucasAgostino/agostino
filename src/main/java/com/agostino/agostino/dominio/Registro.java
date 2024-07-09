package com.agostino.agostino.dominio;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "registros", uniqueConstraints = { @UniqueConstraint(columnNames = {"vigilador_id", "fecha_inicio"})})
public class Registro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vigilador_id") // Nombre de la columna en la tabla 'registro' que referencia al vigilador
    private Vigilador vigilador;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "objetivo_id") // Nombre de la columna en la tabla 'registro' que referencia al objetivo
    private Objetivo objetivo;

    @Column(name = "fehca_inicio")
    private LocalDateTime fechaInicio;
    @Column(name = "fecha_fin")
    private LocalDateTime fechaFin;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Vigilador getVigilador() {
        return vigilador;
    }

    public void setVigilador(Vigilador vigilador) {
        this.vigilador = vigilador;
    }

    public Objetivo getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(Objetivo objetivo) {
        this.objetivo = objetivo;
    }
    
    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDateTime getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDateTime fechaFin) {
        this.fechaFin = fechaFin;
    }
}
