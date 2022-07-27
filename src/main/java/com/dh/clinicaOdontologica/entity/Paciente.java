package com.dh.clinicaOdontologica.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString

@Entity
@Table (name="PACIENTES")
public class Paciente {

    @Id
    @SequenceGenerator(name = "paciente_sequence", sequenceName = "paciente_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "paciente_sequence")
    private Long id;

    @Column (length=100)
    private String nombre;
    @Column (length=100)
    private String apellido;
    @Column (length=20)
    private String dni;
    //
    @Column
    private Date fechaIngreso;

//aca no va cascade = CascadeType.ALL xq en ese caso si eliminaria el domiciilio eliminaria al paciente fetch = FetchType.LAZY
    @OneToOne(cascade = CascadeType.ALL)//, fetch= FetchType.LAZY
    @JoinColumn(name="id_domicilio", referencedColumnName="id" )
//@Tostring.exclude seria para q lombok lo oculte digamos

    private Domicilio domicilio;

    //Un paciente tiene muchos turnos traemos el atributo paciente de la clase turno esto viene por defecto , cascade = CascadeType.ALL en uno a muchos muchos a muchos
// paciente es el atributo de la tabla turno q hace referencia a esta clase es el enlace , trae todos los turnos q tengan ese id 
    @OneToMany(mappedBy ="paciente", fetch=FetchType.LAZY)//,fetch = FetchType.LAZY
    @JsonIgnore
    private Set<Turno>turnos= new HashSet<>();

//  agrega un constructor sin id xq este no se vuelve a modificar...
// el id no deberia tener setter


    public Paciente(String nombre, String apellido, String dni, Date fechaIngreso,Domicilio domicilio) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaIngreso = fechaIngreso;
        this.domicilio = domicilio;
    }

    public Paciente(){}
}
