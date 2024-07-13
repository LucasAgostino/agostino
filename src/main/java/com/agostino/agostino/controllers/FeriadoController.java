package com.agostino.agostino.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agostino.agostino.dominio.Feriado;
import com.agostino.agostino.service.FeriadoService;




@RestController
@RequestMapping("/feriado")
public class FeriadoController {
    @Autowired
    private FeriadoService feriadoService;

    @PostMapping("/guardar")
    public void postMethodName(@RequestBody Feriado feriado ) {
        feriadoService.guardarFeriado(feriado);
    }
    @GetMapping("/get")
    public List<Feriado> getMethodName() {
        return feriadoService.findAllFeriados();
    }
    
    // Endpoint para eliminar feriados en caso de haber sido mal insertados
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarFeriado(@PathVariable("id") Long id) {
        try {
            feriadoService.eliminarFeriado(id);
            return ResponseEntity.ok("Feriado eliminado correctamente con id: " + id);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
}
