package com.agostino.agostino.service;

import java.util.List;

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

    public String cambiarEstadoActivoPorid(long id) {
        // Obtener el vigilador por legajo
        Objetivo objetivo = objetivoRepository.findById(id);

        // Cambiar el estado activo
        objetivo.setActivo(!objetivo.isActivo()); // Cambia el estado activo: true -> false, false -> true

        // Guardar los cambios en la base de datos
        objetivoRepository.save(objetivo);

        // Devolver mensaje específico
        if (objetivo.isActivo()) {
            return "Objetivo subido correctamente" ;
        } else {
            return "Objetivo dado de baja correctamente";
        }
    }

    public List<Objetivo> findAll(){
        return objetivoRepository.findAll();
    }

    // Otros métodos de servicio para operaciones con objetivos
}

