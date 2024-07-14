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

import com.agostino.agostino.dominio.Vigilador;
import com.agostino.agostino.service.VigiladorService;




@RestController
@RequestMapping("/vigilador")
public class VigiladorController {

    @Autowired
    private VigiladorService vigiladorService;

    // Endpoint para guardar un vigilador
    @PostMapping("/guardar")
    public void guardarVigilador(@RequestBody Vigilador vigilador) {
        vigiladorService.guardarVigilador(vigilador);
    }

    // Endpoint para buscar un vigilador por legajo
    @GetMapping("/{legajo}")
    public Vigilador buscarPorLegajo(@PathVariable long legajo) {
        return vigiladorService.findByLegajo(legajo);
    }

    // Endopoint para asignarle un supervisor a un vigilador
    @PutMapping("/{legajo}/supervisor")
    public ResponseEntity<String> actualizarSupervisor(
        @PathVariable("legajo") Long legajo,
        @RequestBody Long nuevoSupervisorLegajo) {

    try {
        vigiladorService.actualizarSupervisor(legajo, nuevoSupervisorLegajo);
        return ResponseEntity.ok("Supervisor actualizado correctamente");
    } catch (RuntimeException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}

    @GetMapping("/{legajo}/vigilador")
    public List<Vigilador> buscarVigiladoresDeSupervisor(@PathVariable("legajo") Long legajo) {
        return vigiladorService.obtenerVigiladoresPorSupervisorLegajo(legajo);
    }

    @GetMapping("/todos")
    public List<Vigilador> getMethodName() {
        return vigiladorService.findAll();
    }
    
    // Endpoint para cambiar el estado activo de un vigilador por legajo
    @PutMapping("/{legajo}/estado")
    public ResponseEntity<String> cambiarEstadoActivoPorLegajo(@PathVariable("legajo") long legajo) {
        try {
            String mensaje = vigiladorService.cambiarEstadoActivoPorLegajo(legajo);
            return ResponseEntity.ok(mensaje);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
}
