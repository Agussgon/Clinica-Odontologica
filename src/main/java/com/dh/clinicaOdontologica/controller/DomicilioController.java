package com.dh.clinicaOdontologica.controller;


import com.dh.clinicaOdontologica.dto.DomicilioDTO;
import com.dh.clinicaOdontologica.entity.Domicilio;
import com.dh.clinicaOdontologica.exceptions.ResourceNotFoundException;
import com.dh.clinicaOdontologica.service.DomicilioService;
import com.dh.clinicaOdontologica.service.impl.DomicilioServiceImpl;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RestController
@RequestMapping("/domicilios")
public class DomicilioController {


    @Autowired
    DomicilioServiceImpl domicilioService;

    @GetMapping
    public ResponseEntity <List<Domicilio>> listarDomicilios() {
        return ResponseEntity.ok(domicilioService.buscarTodos());

    }

    @GetMapping("/{id}")
    public ResponseEntity<Domicilio> buscarDomicilio(@PathVariable Long id) {
        Domicilio domicilio = domicilioService.buscar(id).orElse(null);
        if(domicilio == null)
        { return ResponseEntity.status(HttpStatus.NOT_FOUND).build();}
        else
        {return ResponseEntity.ok(domicilio);}
    }

    // me parece q no esta bien q el service retorne un domicilio
    @PostMapping("/registrar")
    public ResponseEntity<Domicilio> registrarDomicilio(@RequestBody Domicilio domicilio) {
        if(domicilio != null){
        Domicilio domicilioNuevo = domicilioService.registrar(domicilio);
        return ResponseEntity.ok(domicilioNuevo);}
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarDomicilio(@PathVariable Long id) throws ResourceNotFoundException {
        domicilioService.eliminar(id);
        return ResponseEntity.ok("Domicilio con id "+id+" eliminado");

    }

    @PutMapping("/actualizar")
    public ResponseEntity<Domicilio> actualizarDomicilio(@RequestBody Domicilio domicilio) {
        Optional<Domicilio> domicilioA= domicilioService.buscar(domicilio.getId());
        if(domicilio != null && domicilioA.isPresent()){
            return ResponseEntity.ok( domicilioService.actualizar(domicilio));}
        else{ return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); }
    }
}
