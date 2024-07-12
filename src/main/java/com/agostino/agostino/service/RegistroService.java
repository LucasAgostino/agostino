package com.agostino.agostino.service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agostino.agostino.dominio.HorasTrabajadas;
import com.agostino.agostino.dominio.Registro;
import com.agostino.agostino.dominio.Vigilador;
import com.agostino.agostino.repository.Iregistro;
import com.agostino.agostino.repository.Ivigilador;

@Service
public class RegistroService {
    @Autowired
    private Iregistro registrorepository;
    @Autowired
    private Ivigilador vigiladorrepository;
    @Autowired
    private FeriadoService feriadorepository;

    // Validar si el vigilador y el objetivo existen antes de guardar el registro
    public void guardarRegistro(Registro registro) {
        registrorepository.save(registro);
    }

    /* Calcula las horas totales del mes y tambien llama a la funcion para calcular las horas nocturnas */
    public HorasTrabajadas getHorasTrabajadas(long legajo, int year, int month) {
        Vigilador vigilador = vigiladorrepository.findByLegajo(legajo);
        long totalHours = 0;
        if (vigilador != null) {
            Long id = vigilador.getId();
            List<Registro> registros = registrorepository.findAllByYearAndMonthAndVigilador(year, month, id);

            for (Registro registro : registros) {
                Duration duration = Duration.between(registro.getFechaInicio(), registro.getFechaFin());
                totalHours += duration.toHours();
            }
            long horasNocturnas = getTotalNocturnalHoursWorked(registros);
            long horasFeriados = getHorasTrabajadasEnFeriado(registros);
            return new HorasTrabajadas(totalHours, horasNocturnas,horasFeriados);

        } else {
            return new HorasTrabajadas(0, 0, 0);
        }
    }

    private long getTotalNocturnalHoursWorked(List<Registro> registros) {
        long totalNocturnalHours = 0; // Crea la variable para saber la cantidad de horas totales trabajadas en el
                                      // turno noche

        LocalTime nocturnalStart = LocalTime.of(21, 0); // Asigna la hora a la que inicia el turno nocturno
        LocalTime nocturnalEnd = LocalTime.of(5, 0); // Asigna la hora a la que termina el turno nocturno

        for (Registro registro : registros) { // Recorre la lista de registro
            LocalDateTime start = registro.getFechaInicio(); // Consigue la fecha de inicio del registro
            LocalDateTime end = registro.getFechaFin(); // Consigue la fecha de fin del registro

            while (start.isBefore(end)) {
                LocalDateTime startOfDay = start.toLocalDate().atStartOfDay();
                LocalDateTime endOfDay = startOfDay.plusDays(1);

                LocalDateTime nocturnalStartDateTime = start.toLocalDate().atTime(nocturnalStart);
                LocalDateTime nocturnalEndDateTime = start.toLocalDate().plusDays(1).atTime(nocturnalEnd);

                if (start.isBefore(nocturnalEndDateTime) && end.isAfter(nocturnalStartDateTime)) {
                    LocalDateTime nocturnalStartInRange = start.isBefore(nocturnalStartDateTime)
                            ? nocturnalStartDateTime
                            : start;
                    LocalDateTime nocturnalEndInRange = end.isAfter(nocturnalEndDateTime) ? nocturnalEndDateTime : end;
                    Duration nocturnalDuration = Duration.between(nocturnalStartInRange, nocturnalEndInRange);
                    totalNocturnalHours += nocturnalDuration.toHours();
                }

                start = endOfDay;
            }
        }
        return totalNocturnalHours;
    }
    
    private long getHorasTrabajadasEnFeriado(List<Registro> registros) {
        long totalFeriadoHours = 0;
    
        for (Registro registro : registros) {
            LocalDateTime start = registro.getFechaInicio();
            LocalDateTime end = registro.getFechaFin();
    
            while (start.isBefore(end)) {
                LocalDateTime endOfDay = start.toLocalDate().atStartOfDay().plusDays(1);
                LocalDateTime periodEnd = end.isBefore(endOfDay) ? end : endOfDay;
    
                // Verifica si el inicio es un día feriado
                if (feriadorepository.isFeriado(start.toLocalDate())) {
                    Duration duration = Duration.between(start, periodEnd);
                    totalFeriadoHours += duration.toHours();
                }
    
                // Si el período termina en un día feriado
                if (feriadorepository.isFeriado(periodEnd.toLocalDate())) {
                    Duration duration = Duration.between(start, periodEnd);
                    totalFeriadoHours += duration.toHours();
                }
    
                // Actualiza el inicio para el siguiente ciclo
                start = periodEnd;
            }
        }
    
        return totalFeriadoHours;
    }
    
    }