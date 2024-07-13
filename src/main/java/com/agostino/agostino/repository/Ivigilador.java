package com.agostino.agostino.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agostino.agostino.dominio.Vigilador;

@Repository
public interface Ivigilador extends JpaRepository <Vigilador, Long> {

    public Vigilador findByLegajo(long legajo);

    public boolean existsByLegajo(Long supervisorLegajo);

    public List<Vigilador> findAllBySupervisorLegajo(Long supervisorLegajo);

    public List<Vigilador> findAllByOrderByLegajoAsc();
}
