package com.dh.clinicaOdontologica.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString

@Entity
@Table(name="TURNOS")
public class Turno {

    @Id
    @SequenceGenerator(name = "turno_sequence", sequenceName = "turno_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "turno_sequence")
    private Long id;

    @Column
    private Date fecha;


    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name="id_paciente", referencedColumnName = "id")
    private Paciente paciente;

    @ManyToOne (fetch = FetchType.EAGER)//CascadeType.MERGE
    @JoinColumn(name="id_odontologo")//, referencedColumnName = "id"
    private Odontologo odontologo;



    public Turno(Date fecha, Paciente paciente, Odontologo odontologo) {
        this.fecha = fecha;
        this.paciente = paciente;
        this.odontologo = odontologo;
    }
    public Turno(){}


}
