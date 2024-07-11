package com.agostino.agostino.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agostino.agostino.dominio.Objetivo;
import com.agostino.agostino.service.ObjetivoService;

@RestController
@RequestMapping("/objetivos")
public class ObjetivoController {

    @Autowired
    private ObjetivoService objetivoService;

    // Endpoint para guardar un objetivo
    @PostMapping("/guardar")
    public void guardarObjetivo(@RequestBody Objetivo objetivo) {
        objetivoService.guardarObjetivo(objetivo);
    }
    // Otros métodos de controlador para operaciones con objetivos
}
