package com.agostino.agostino.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.agostino.agostino.dominio.HorasTrabajadas;
import com.agostino.agostino.dominio.Registro;
import com.agostino.agostino.service.RegistroService;

@RestController
@RequestMapping("/api/registros")
public class RegistroController {

    @Autowired
    private RegistroService registroService;

    // Endpoint para guardar un registro
    @PostMapping("/guardar")
    public void guardarRegistro(@RequestBody Registro registro) {
        registroService.guardarRegistro(registro);
    }

    // Endpoint para obtener las horas trabajadas de un vigilador en un mes y año específicos
    @GetMapping("/horas-trabajadas")
    public HorasTrabajadas getHorasTrabajadas(
            @RequestParam long legajo,
            @RequestParam int year,
            @RequestParam int month) {
        return registroService.getHorasTrabajadas(legajo, year, month);
    }

    // Endpoint para calcular el costo total basado en horas trabajadas y tarifas por hora
    @GetMapping("/calcular-costo")
    public double calcularCostoTotal(
            @RequestParam long legajo,
            @RequestParam int year,
            @RequestParam int month,
            @RequestParam double valorHoraDia,
            @RequestParam double valorHoraNoche) {
        return registroService.calcularCostoTotal(legajo, year, month, valorHoraDia, valorHoraNoche);
    }
}
