package com.dh.clinicaOdontologica.dto;
import com.dh.clinicaOdontologica.entity.Odontologo;
import com.dh.clinicaOdontologica.entity.Paciente;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter

@JsonIgnoreProperties(ignoreUnknown = true)
public class TurnoDTO {
    private Long id;
    private Date fecha;
    private PacienteDTO pacienteDto;
    private OdontologoDTO odontologoDto;
}
