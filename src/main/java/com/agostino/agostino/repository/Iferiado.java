package com.agostino.agostino.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agostino.agostino.dominio.Feriado;

public interface Iferiado extends JpaRepository<Feriado, Long> {
    Optional<Feriado> findByFecha(LocalDate fecha);
    
    @Override
    List<Feriado> findAll(); 
}
