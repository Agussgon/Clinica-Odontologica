package com.dh.clinicaOdontologica.dto;
import com.dh.clinicaOdontologica.entity.Turno;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class OdontologoDTO {

    private Long id;
    private String nombre;
    private String apellido;
    private  String matricula;
    private Set<TurnoDTO> turnosDto = new HashSet<>();
}
