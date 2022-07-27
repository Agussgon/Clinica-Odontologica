package com.dh.clinicaOdontologica.dto;
import com.dh.clinicaOdontologica.entity.Domicilio;
import com.dh.clinicaOdontologica.entity.Turno;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter

//@JsonIgnoreProperties(ignoreUnknown = true)
public class PacienteDTO {

    private Long id;
    private String nombre;
    private String apellido;
    private String dni;
    private Date fechaIngreso;
    private DomicilioDTO domicilioDto;
    // los turnos van en el dto ? supuestamente si
    //private Set<TurnoDTO> turnosDto= new HashSet<>();


    public PacienteDTO(Long id, String nombre, String apellido, String dni, Date fechaIngreso, DomicilioDTO domicilioDto) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaIngreso = fechaIngreso;
        this.domicilioDto = domicilioDto;
    }

}
