package com.dh.clinicaOdontologica.controller;

import com.dh.clinicaOdontologica.dto.PacienteDTO;
import com.dh.clinicaOdontologica.dto.TurnoDTO;
import com.dh.clinicaOdontologica.entity.Paciente;
import com.dh.clinicaOdontologica.entity.Turno;
import com.dh.clinicaOdontologica.exceptions.ResourceNotFoundException;
import com.dh.clinicaOdontologica.service.PacienteService;
import com.dh.clinicaOdontologica.service.TurnoService;
import com.dh.clinicaOdontologica.service.impl.OdontologoServiceImpl;
import com.dh.clinicaOdontologica.service.impl.PacienteServiceImpl;
import com.dh.clinicaOdontologica.service.impl.TurnoServiceImpl;
import jdk.jfr.Unsigned;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    @Autowired
    TurnoServiceImpl turnoService;

   @Autowired
   PacienteServiceImpl pacienteService;

    @Autowired
    OdontologoServiceImpl odontologoService;

    @PostMapping("/registrar")
    public ResponseEntity<Turno> registrarTurno(@RequestBody Turno turno) {
        if (turno != null && pacienteService.buscarPaciente(turno.getPaciente().getId()).isPresent()
                && odontologoService.buscarOdontologo(turno.getOdontologo().getId()).isPresent() ) {
            return ResponseEntity.ok(turnoService.registrarTurno(turno));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Turno> buscarTurno(@PathVariable Long id) {
        Turno turno= turnoService.buscarTurno(id).orElse(null);;
       if(turno == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else{
           return ResponseEntity.ok(turno);
       }
    }

    @GetMapping
    public ResponseEntity<List<Turno>> listarTurnos(){
        return ResponseEntity.ok(turnoService.buscarTurnos());
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarTurno(@PathVariable Long id ) throws ResourceNotFoundException {
            turnoService.eliminarTurno(id);
            return ResponseEntity.ok("Turno con id "+id+" eliminado");
    }

    @PutMapping("/actualizar")
    public ResponseEntity<Turno> turno(@RequestBody Turno turno){
        Optional<Turno> turnoA = turnoService.buscarTurno(turno.getId());
        if(turno !=null && turnoA.isPresent()){
            return ResponseEntity.ok(turnoService.actualizarTurno(turno));
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}

