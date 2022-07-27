package com.dh.clinicaOdontologica.service.impl;


import com.dh.clinicaOdontologica.dto.TurnoDTO;
import com.dh.clinicaOdontologica.entity.Turno;
import com.dh.clinicaOdontologica.exceptions.ResourceNotFoundException;
import com.dh.clinicaOdontologica.repository.TurnoRepository;
import com.dh.clinicaOdontologica.service.TurnoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



@Service

public class TurnoServiceImpl implements TurnoService {

    @Autowired
    TurnoRepository turnoRepository;

   // @Autowired
   // ObjectMapper mapper;

    private static final Logger logger= Logger.getLogger(TurnoServiceImpl.class);


    @Override
    public Turno registrarTurno(Turno turno) {
        logger.info("registro el turno"+ turno);
        return turnoRepository.save(turno);
    }

    @Override
    public Optional<Turno> buscarTurno(Long id) {
        Optional<Turno>turno= turnoRepository.findById(id);
        if(turno.isPresent()){
     // logger.info("el id solicitado n°"+id+"corresponde al turno "+ turno);
      return turno;}else{
      //      logger.error("No se encontró ningún turno con el id solicitado "+id);
        return Optional.empty();}
    }

    @Override
    public List<Turno> buscarTurnos() {
        List<Turno> turnos =turnoRepository.findAll();
        return turnos;

    }

    @Override
    public void eliminarTurno(Long id) throws ResourceNotFoundException {
        if(turnoRepository.findById(id) ==null) throw new ResourceNotFoundException("Turno" +
                "no encontrado con id"+ id);
        turnoRepository.deleteById(id);
        logger.info("el turno con id "+id + " fue eliminado");
    }

    @Override
    public Turno actualizarTurno(Turno turno) {

        return turnoRepository.save(turno);

    }
}
