package com.dh.clinicaOdontologica.service.impl;

import com.dh.clinicaOdontologica.dto.DomicilioDTO;
import com.dh.clinicaOdontologica.entity.Domicilio;
import com.dh.clinicaOdontologica.exceptions.ResourceNotFoundException;
import com.dh.clinicaOdontologica.repository.DomicilioRepository;
import com.dh.clinicaOdontologica.service.DomicilioService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DomicilioServiceImpl implements DomicilioService {

    // iniciar el repository
    @Autowired
    private DomicilioRepository domicilioRepository;
 //   @Autowired
 //   ObjectMapper mapper;

    // mapper , guardarlo ver si es exitoso .... catch , me cambia lo q retorna
    // problema al registrar un domicilio con respecto al id del paciente
    @Override
    public Domicilio registrar(Domicilio domicilio) {
        return domicilioRepository.save(domicilio);
    }

    @Override
    public Optional<Domicilio> buscar(Long id) {
        Optional<Domicilio> domicilio= domicilioRepository.findById(id);
        if(domicilio.isPresent()) {return domicilio;}
        else{ return Optional.empty();}
    }



    // es necesario hacer el for? aca y el set de domicioDTO para q me pa q si va foor
    @Override
    public List<Domicilio> buscarTodos() {
        List <Domicilio> listaDomicilios=domicilioRepository.findAll();
        return listaDomicilios;
    }


    @Override
    public void eliminar(Long id) throws ResourceNotFoundException {
        if(domicilioRepository.findById(id) == null)throw new ResourceNotFoundException("Domicilio " +
                "no encontrado con id"+ id);
      domicilioRepository.deleteById(id);
    }

    @Override
    public Domicilio actualizar(Domicilio domicilio) {
       return  domicilioRepository.save(domicilio);

    }
}
