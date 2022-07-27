package com.dh.clinicaOdontologica;

import com.dh.clinicaOdontologica.entity.Domicilio;
import com.dh.clinicaOdontologica.entity.Paciente;
import com.dh.clinicaOdontologica.exceptions.ResourceNotFoundException;
import com.dh.clinicaOdontologica.service.impl.PacienteServiceImpl;
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
public class PacienteServiceTest {

    @Autowired
    PacienteServiceImpl pacienteService;

    private final static Logger logger= Logger.getLogger(OdontologoServiceTests.class);

    public void generarPaciente(){
        Domicilio domicilio= new Domicilio("Corrientes","123","CABA","Buenos Aires");
        Paciente paciente=pacienteService.registrarPaciente((new Paciente("Juan","Perez","20300400",new Date(),domicilio)));
    }
    @Test
    public void registrarOdontologo(){
        Domicilio domicilio= new Domicilio("Corrientes","123","CABA","Buenos Aires");
        Paciente paciente=pacienteService.registrarPaciente((new Paciente("Juan","Ruiz","22300400",new Date(),domicilio)));
        logger.debug("guardando paciente"+ paciente);
        Assert.assertTrue(paciente.getId() != null);
    }

    @Test
    public void eliminarOdontologo() throws ResourceNotFoundException {
        this.generarPaciente();
        pacienteService.eliminarPaciente(1L);
        logger.debug("eliminando paciente por id");
        Assert.assertTrue(pacienteService.buscarPaciente(1L).isEmpty());

    }





}
