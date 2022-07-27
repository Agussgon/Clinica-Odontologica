package com.dh.clinicaOdontologica.service;

import com.dh.clinicaOdontologica.dto.OdontologoDTO;
import com.dh.clinicaOdontologica.entity.Odontologo;
import com.dh.clinicaOdontologica.exceptions.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

public interface OdontologoService {



    Odontologo registrarOdontologo(Odontologo odontologo);
    //puede devolver algo o no
    Optional<Odontologo> buscarOdontologo(Long id);
    List<Odontologo> buscarOdontologos();
    void eliminarOdontologo(Long id) throws ResourceNotFoundException;
    Odontologo actualizarOdontologo(Odontologo odontologo);
}
