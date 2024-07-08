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

    private LocalDateTime horaini;
    private LocalDateTime horafin;

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

    public LocalDateTime getHoraini() {
        return horaini;
    }

    public void setHoraini(LocalDateTime horaini) {
        this.horaini = horaini;
    }

    public LocalDateTime getHorafin() {
        return horafin;
    }

    public void setHorafin(LocalDateTime horafin) {
        this.horafin = horafin;
    }
}
