package com.dh.clinicaOdontologica.service;

import com.dh.clinicaOdontologica.entity.Domicilio;
import com.dh.clinicaOdontologica.exceptions.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

public interface DomicilioService {

    Domicilio registrar(Domicilio domicilio);

    Optional<Domicilio> buscar(Long id);
    List<Domicilio> buscarTodos();
    void eliminar(Long id) throws ResourceNotFoundException;
    Domicilio actualizar(Domicilio domicilio);

}
