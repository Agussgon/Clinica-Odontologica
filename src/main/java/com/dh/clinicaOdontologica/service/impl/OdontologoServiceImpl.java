package com.dh.clinicaOdontologica.service.impl;

import com.dh.clinicaOdontologica.dto.OdontologoDTO;
import com.dh.clinicaOdontologica.entity.Odontologo;
import com.dh.clinicaOdontologica.exceptions.ResourceNotFoundException;
import com.dh.clinicaOdontologica.repository.OdontologoRepository;
import com.dh.clinicaOdontologica.service.OdontologoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;




@Service
public class OdontologoServiceImpl implements OdontologoService {

    @Autowired
    OdontologoRepository odontologoRepository;

   // @Autowired
   //  ObjectMapper mapper;


    @Override
    public Odontologo registrarOdontologo(Odontologo odontologo) {

        return odontologoRepository.save(odontologo);
    }

    @Override
    public Optional<Odontologo> buscarOdontologo(Long id) {
     Optional<Odontologo> odontologo = odontologoRepository.findById(id);
        if(odontologo.isPresent()){
        return odontologo;
     }
      else{  return Optional.empty();}
    }

    @Override
    public List<Odontologo> buscarOdontologos() {
         List<Odontologo>odontologos= odontologoRepository.findAll();

        return odontologos;
    }

    @Override
    public void eliminarOdontologo(Long id) throws ResourceNotFoundException {
        if(odontologoRepository.findById(id) == null)throw new ResourceNotFoundException("Odontologo " +
                "no encontrado con id"+ id);
        odontologoRepository.deleteById(id);
    }

    @Override
    public Odontologo actualizarOdontologo(Odontologo odontologo) {
       return  odontologoRepository.save(odontologo);

    }
}
