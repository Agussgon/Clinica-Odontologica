package com.dh.clinicaOdontologica.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

//@JsonIgnoreProperties(ignoreUnknown = true)
public class DomicilioDTO {

    private Long id;
    private String calle;
    private String numero;
    private String localidad;
    private String provincia;
    //private PacienteDTO pacienteDto;


    public DomicilioDTO(Long id, String calle, String numero, String localidad, String provincia) {
        this.id = id;
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
        this.provincia = provincia;
    }
}
