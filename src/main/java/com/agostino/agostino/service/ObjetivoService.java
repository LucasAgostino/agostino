package com.agostino.agostino.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agostino.agostino.dominio.Objetivo;
import com.agostino.agostino.repository.Iobjetivo;

@Service
public class ObjetivoService {

    @Autowired
    private Iobjetivo objetivoRepository;

    public void guardarObjetivo(Objetivo objetivo) {
        objetivoRepository.save(objetivo);
    }

    // Otros métodos de servicio para operaciones con objetivos
}

