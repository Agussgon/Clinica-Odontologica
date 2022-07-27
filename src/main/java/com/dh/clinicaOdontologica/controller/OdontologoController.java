package com.dh.clinicaOdontologica.controller;

import com.dh.clinicaOdontologica.dto.OdontologoDTO;
import com.dh.clinicaOdontologica.entity.Odontologo;
import com.dh.clinicaOdontologica.exceptions.ResourceNotFoundException;
import com.dh.clinicaOdontologica.service.impl.OdontologoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

@RequestMapping("/odontologos")
public class OdontologoController {

    @Autowired
    OdontologoServiceImpl odontologoService;

    @PostMapping("/registrar")
    public ResponseEntity<Odontologo> registrarOdontologo(@RequestBody Odontologo odontologo) {
        if (odontologo != null) {
            Odontologo odontologoNuevo = odontologoService.registrarOdontologo(odontologo);
            return ResponseEntity.ok(odontologoNuevo);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Odontologo> buscarOdontologo(@PathVariable Long id) {
        Odontologo odontologo = odontologoService.buscarOdontologo(id).orElse(null);
        if (odontologo == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.ok(odontologo);
        }
    }

    @GetMapping
    public ResponseEntity<List<Odontologo>> listarOdontologos() {
        return ResponseEntity.ok(odontologoService.buscarOdontologos());
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarOdontologo(@PathVariable Long id) throws ResourceNotFoundException {

            odontologoService.eliminarOdontologo(id);
            return ResponseEntity.ok("Odontologo con id "+id+" eliminado");
    }

    @PutMapping ("/actualizar")
    public ResponseEntity<Odontologo> actualizarOdontologo(@RequestBody Odontologo odontologo){
        Optional<Odontologo> odontologoBuscado= odontologoService.buscarOdontologo(odontologo.getId());
        if(odontologoBuscado.isPresent()){
           return ResponseEntity.ok(  odontologoService.actualizarOdontologo(odontologo));
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


}
