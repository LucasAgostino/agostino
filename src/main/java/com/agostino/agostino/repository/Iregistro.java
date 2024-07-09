package com.agostino.agostino.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.agostino.agostino.dominio.Registro;
import com.agostino.agostino.dominio.Vigilador;

@Repository
public interface Iregistro extends JpaRepository<Registro, Long> {
    public List<Registro> findAllByVigilador(Vigilador vigilador);

    @Query("SELECT r FROM Registro r WHERE YEAR(r.fechaInicio) = :year AND MONTH(r.fechaInicio) = :month AND r.vigilador.id = :vigiladorId")
    List<Registro> findAllByYearAndMonthAndVigilador(
            @Param("year") int year,
            @Param("month") int month,
            @Param("vigiladorId") Long vigiladorId);
}
