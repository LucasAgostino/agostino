package com.agostino.agostino.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agostino.agostino.dominio.Feriado;
import com.agostino.agostino.repository.Iferiado;


@Service
public class FeriadoService {

    @Autowired
    private Iferiado feriadoRepository;

    public boolean isFeriado(LocalDate fecha) {
        return feriadoRepository.findByFecha(fecha).isPresent();
    }
    public void guardarFeriado(Feriado feriado){
        feriadoRepository.save(feriado);
    }
    public List<Feriado> findAllFeriados(){
        return feriadoRepository.findAll();
    }
}
