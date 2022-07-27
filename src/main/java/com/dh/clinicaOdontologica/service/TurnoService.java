package com.dh.clinicaOdontologica.service;

import com.dh.clinicaOdontologica.dto.TurnoDTO;
import com.dh.clinicaOdontologica.entity.Turno;
import com.dh.clinicaOdontologica.exceptions.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

public interface TurnoService {

    Turno registrarTurno(Turno turno);
    Optional<Turno> buscarTurno(Long id);
    List<Turno> buscarTurnos();
    void eliminarTurno(Long id) throws ResourceNotFoundException;
    Turno actualizarTurno(Turno turno);
}
