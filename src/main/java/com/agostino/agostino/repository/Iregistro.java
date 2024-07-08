package com.agostino.agostino.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agostino.agostino.dominio.Registro;

@Repository
public interface Iregistro extends JpaRepository<Registro, Long> {
}
