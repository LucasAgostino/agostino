package com.agostino.agostino.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agostino.agostino.dominio.Registro;
import com.agostino.agostino.repository.Iregistro;


@Service
public class RegistroService {
    @Autowired private Iregistro registrorepository;
    
        // Validar si el vigilador y el objetivo existen antes de guardar el registro
        public void guardarRegistro(Registro registro) {
            registrorepository.save(registro);
        }
}
