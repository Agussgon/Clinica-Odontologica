package com.dh.clinicaOdontologica;


import com.dh.clinicaOdontologica.entity.Domicilio;
import com.dh.clinicaOdontologica.entity.Odontologo;
import com.dh.clinicaOdontologica.entity.Paciente;
import com.dh.clinicaOdontologica.entity.Turno;
import com.dh.clinicaOdontologica.exceptions.ResourceNotFoundException;
import com.dh.clinicaOdontologica.service.impl.OdontologoServiceImpl;
import com.dh.clinicaOdontologica.service.impl.PacienteServiceImpl;
import com.dh.clinicaOdontologica.service.impl.TurnoServiceImpl;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
public class TurnoServiceTests {

@Autowired
TurnoServiceImpl turnoService;

@Autowired
PacienteServiceImpl pacienteService;

@Autowired
OdontologoServiceImpl odontologoService;

private final static Logger logger= Logger.getLogger(OdontologoServiceTests.class);



    public void cargarDatos(){
    Domicilio domicilio= new Domicilio("Corrientes","123","CABA","Buenos Aires");
    odontologoService.registrarOdontologo(new Odontologo("Luz","Perez","2354"));
    pacienteService.registrarPaciente(new Paciente("Juan","Ruiz","30203203",new Date(),domicilio));
    }

    @Test
    public void registrarTurno(){
        this.cargarDatos();
        turnoService.registrarTurno(new Turno(new Date(),pacienteService.buscarPaciente(1L).get(),
                odontologoService.buscarOdontologo(1L).get()));
        logger.debug("guardando turno");
        Assert.assertNotNull(turnoService.buscarTurno(1L));
    }

    @Test
    public void eliminarTurno() throws ResourceNotFoundException {
        turnoService.eliminarTurno(1L);
        logger.debug("eliminando turno por id");
        Assert.assertTrue(turnoService.buscarTurno(1L).isEmpty());
        //Assert.assertFalse(turnoService.buscar(1).isPresent()); otra forma
        //No class com.dh.clinicaOdontologica.entity.Turno entity with id 1 exists!
    }


}
