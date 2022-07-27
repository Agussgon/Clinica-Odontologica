package com.dh.clinicaOdontologica.service.impl;

import com.dh.clinicaOdontologica.dto.DomicilioDTO;
import com.dh.clinicaOdontologica.dto.PacienteDTO;
import com.dh.clinicaOdontologica.entity.Domicilio;
import com.dh.clinicaOdontologica.entity.Paciente;
import com.dh.clinicaOdontologica.exceptions.ResourceNotFoundException;
import com.dh.clinicaOdontologica.repository.DomicilioRepository;
import com.dh.clinicaOdontologica.repository.PacienteRepository;
import com.dh.clinicaOdontologica.service.PacienteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class PacienteServiceImpl implements PacienteService {
  @Autowired
    PacienteRepository pacienteRepository;
  //@Autowired
  //  ObjectMapper mapper;


  //esto deberia ser un void no?
    @Override
    public Paciente registrarPaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    @Override
    public Optional<Paciente> buscarPaciente(Long id) {
        Optional<Paciente> paciente = pacienteRepository.findById(id);
        if(paciente.isPresent()) {
            return paciente;
        }else{ return Optional.empty();}
    }


    @Override
    public List<Paciente> buscarPacientes() {
       List<Paciente> pacientes =pacienteRepository.findAll();
       return pacientes;
    }


    @Override
    public void eliminarPaciente(Long id) throws ResourceNotFoundException {
        if(pacienteRepository.findById(id) ==null) throw new ResourceNotFoundException("Paciente " +
                "no encontrado con id"+ id);
       pacienteRepository.deleteById(id);
    }

    @Override
    public Paciente actualizar(Paciente paciente) {
        return pacienteRepository.save(paciente);

    }
}
