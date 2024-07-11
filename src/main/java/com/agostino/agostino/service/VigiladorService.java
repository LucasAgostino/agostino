package com.agostino.agostino.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agostino.agostino.dominio.Vigilador;
import com.agostino.agostino.repository.Ivigilador;

@Service
public class VigiladorService {

    @Autowired
    private Ivigilador vigiladorrepository;

    public void guardarVigilador(Vigilador vigilador) {
        vigiladorrepository.save(vigilador);
    }

    public Vigilador buscarPorLegajo(long legajo) {
        return vigiladorrepository.findByLegajo(legajo);
    }

}
