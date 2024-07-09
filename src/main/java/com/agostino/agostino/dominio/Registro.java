package com.agostino.agostino.dominio;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "registros")
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

    @Column(name = "hora_inicio")
    private LocalDateTime horaInicio;
    @Column(name = "hora_fin")
    private LocalDateTime horaFin;

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
    
    public LocalDateTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalDateTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalDateTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalDateTime horaFin) {
        this.horaFin = horaFin;
    }
}
