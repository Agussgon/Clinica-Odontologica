package com.dh.clinicaOdontologica.service;

import com.dh.clinicaOdontologica.dto.PacienteDTO;
import com.dh.clinicaOdontologica.entity.Paciente;
import com.dh.clinicaOdontologica.exceptions.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

public interface PacienteService {


    Paciente registrarPaciente(Paciente paciente);
    Optional<Paciente> buscarPaciente(Long id);
    List<Paciente> buscarPacientes();
    void eliminarPaciente(Long id) throws ResourceNotFoundException;
    Paciente actualizar(Paciente paciente);
}
