package com.dh.clinicaOdontologica;


import com.dh.clinicaOdontologica.dto.OdontologoDTO;
import com.dh.clinicaOdontologica.entity.Odontologo;
import com.dh.clinicaOdontologica.exceptions.ResourceNotFoundException;
import com.dh.clinicaOdontologica.service.impl.OdontologoServiceImpl;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest

public class OdontologoServiceTests {

@Autowired
OdontologoServiceImpl odontologoService;

private final static Logger logger= Logger.getLogger(OdontologoServiceTests.class);
//No crea el archivo para guardar el logeo
  //  public static void main(String[] args) {
   //     File log4jfile = new File("./src/main/resources/log4j.properties");
    //    PropertyConfigurator.configure(log4jfile.getAbsolutePath());}


    public void generarOdontologo(){
        Odontologo odontologo=odontologoService.registrarOdontologo( (new Odontologo("Luz","Perez","2354")));
    }
    @Test
    public void registrarOdontologo(){
    Odontologo odontologo=odontologoService.registrarOdontologo( (new Odontologo("Pablo","Perez","1234")));
    logger.debug("guardando odontologo"+ odontologo);
    Assert.assertTrue(odontologo.getId() != null);
}

@Test
    public void eliminarOdontologo() throws ResourceNotFoundException {
        this.generarOdontologo();
    odontologoService.eliminarOdontologo(1L);
    logger.debug("eliminando odontologo por id");
    Assert.assertTrue(odontologoService.buscarOdontologo(1L).isEmpty());

}


}
