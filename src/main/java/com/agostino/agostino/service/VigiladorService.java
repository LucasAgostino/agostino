package com.agostino.agostino.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agostino.agostino.dominio.Vigilador;
import com.agostino.agostino.repository.Ivigilador;

@Service
public class VigiladorService {

    @Autowired
    private Ivigilador vigiladorRepository;

    public void guardarVigilador(Vigilador vigilador) {
        // Verificar si el supervisorLegajo existe (si no es null)
        if (vigilador.getSupervisorLegajo() != null) {
            // Aquí debes usar el método adecuado para verificar la existencia por legajo
            boolean supervisorExists = vigiladorRepository.existsByLegajo(vigilador.getSupervisorLegajo());
            if (!supervisorExists) {
                throw new RuntimeException("El legajo del supervisor no existe");
            }
        }

        // Guardar el vigilador si pasa las validaciones
        vigiladorRepository.save(vigilador);
    }

    public Vigilador findByLegajo(long legajo) {
        return vigiladorRepository.findByLegajo(legajo);
    }
    public void actualizarSupervisor(Long legajo, Long nuevoSupervisorLegajo) {
        // Obtener el vigilador que deseas actualizar
        Vigilador vigilador = vigiladorRepository.findByLegajo(legajo);

        // Actualizar el supervisor legajo
        vigilador.setSupervisorLegajo(nuevoSupervisorLegajo);

        // Guardar los cambios en la base de datos
        vigiladorRepository.save(vigilador);
    }
    public List<Vigilador> obtenerVigiladoresPorSupervisorLegajo(Long supervisorLegajo) {
        return vigiladorRepository.findAllBySupervisorLegajo(supervisorLegajo);
    }
    public List<Vigilador> findAll(){
        return vigiladorRepository.findAllByOrderByLegajoAsc();
    }
    public String cambiarEstadoActivoPorLegajo(long legajo) {
        // Obtener el vigilador por legajo
        Vigilador vigilador = vigiladorRepository.findByLegajo(legajo);

        if (vigilador == null) {
            throw new IllegalArgumentException("Vigilador no encontrado con legajo: " + legajo);
        }

        // Cambiar el estado activo
        vigilador.setActivo(!vigilador.isActivo()); // Cambia el estado activo: true -> false, false -> true

        // Guardar los cambios en la base de datos
        vigiladorRepository.save(vigilador);

        // Devolver mensaje específico
        if (vigilador.isActivo()) {
            return "Vigilador subido correctamente con legajo: " + legajo;
        } else {
            return "Vigilador dado de baja correctamente con legajo: " + legajo;
        }
    }

}
