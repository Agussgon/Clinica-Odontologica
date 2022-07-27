package com.dh.clinicaOdontologica.controller;


import com.dh.clinicaOdontologica.dto.PacienteDTO;
import com.dh.clinicaOdontologica.entity.Paciente;
import com.dh.clinicaOdontologica.exceptions.ResourceNotFoundException;
import com.dh.clinicaOdontologica.service.PacienteService;
import com.dh.clinicaOdontologica.service.impl.PacienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping ("/pacientes")
public class PacienteController {

    @Autowired
    PacienteServiceImpl pacienteService;

    @GetMapping
    public ResponseEntity<List<Paciente>> listarPacientes() {
        return ResponseEntity.ok(pacienteService.buscarPacientes());

    }


    @GetMapping("/{id}")
    public ResponseEntity<Paciente> buscarPaciente(@PathVariable Long id) {
        Paciente paciente = pacienteService.buscarPaciente(id).orElse(null);
        if(paciente == null){ return ResponseEntity.status(HttpStatus.NOT_FOUND).build();}
        else{ return ResponseEntity.ok(paciente); }

    }
    // no tendria que retornar nada no?// el error esta al momento de ingresar el pacienteDTO directamente
    //toma al domicilioDTO como nulo
    @PostMapping("/registrar")
    public ResponseEntity<Paciente> registrarPaciente(@RequestBody Paciente paciente) {
        if(paciente != null ){
        Paciente pacienteNuevo = pacienteService.registrarPaciente(paciente);
        return ResponseEntity.ok(pacienteNuevo);}
        else{ return ResponseEntity.status(HttpStatus.BAD_REQUEST).build(); }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarPaciente(@PathVariable Long id) throws ResourceNotFoundException {
        pacienteService.eliminarPaciente(id);
        return ResponseEntity.ok("Paciente con id "+id+" eliminado");

    }

    @PutMapping("/actualizar")
    public ResponseEntity<Paciente> actualizarPaciente(@RequestBody Paciente paciente) {
        Optional<Paciente> pacienteA= pacienteService.buscarPaciente(paciente.getId());
        if(paciente != null && pacienteA.isPresent()){
        return ResponseEntity.ok(pacienteService.actualizar(paciente));}
        else{ return ResponseEntity.status(HttpStatus.BAD_REQUEST).build(); }

    }

}




