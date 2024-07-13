package com.agostino.agostino.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agostino.agostino.dominio.Objetivo;
import com.agostino.agostino.service.ObjetivoService;



@RestController
@RequestMapping("/objetivo")
public class ObjetivoController {

    @Autowired
    private ObjetivoService objetivoService;

    // Endpoint para guardar un objetivo
    @PostMapping("/guardar")
    public void guardarObjetivo(@RequestBody Objetivo objetivo) {
        objetivoService.guardarObjetivo(objetivo);
    }

    // Endpoint para baja logica de objetivo
    @PutMapping("/{id}")
    public ResponseEntity<String> putMethodName(@PathVariable long id) {
        String mensaje = objetivoService.cambiarEstadoActivoPorid(id);
        return ResponseEntity.ok(mensaje);
    }

    // Endpoint para tener todos los objetivos
    @GetMapping("/get")
    public List<Objetivo> getAllObjetivo() {
        return objetivoService.findAll();
    }
    
    // Otros métodos de controlador para operaciones con objetivos
}
