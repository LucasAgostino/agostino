package com.agostino.agostino.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agostino.agostino.dominio.Objetivo;


@Repository
public interface Iobjetivo extends JpaRepository <Objetivo, Long> {
    public Objetivo findById(long id);
}
