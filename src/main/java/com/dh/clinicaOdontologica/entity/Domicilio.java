package com.dh.clinicaOdontologica.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

//(lombok)

@Getter
@Setter
@ToString

// esto es par JPA hibernate
@Entity
//Se etiqueta a la clase como un Bean del tipo entity que va a ser mapeado por el ORM con una tabla de la BD.

@Table(name="DOMICILIOS")


public class Domicilio {
    @Id
   // @SequenceGenerator(name = "domicilio_sequence", sequenceName = "domicilio_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="domicilio_sequence")//
    private Long id;
    private String calle;
    private String numero;
    private String localidad;
    private String provincia;

    // le doy la clave foranea // su elimino el paciente elimino al domicilio cascadeall
  //  @OneToOne(mappedBy= "domicilio",fetch = FetchType.LAZY)
   // private Paciente paciente;
   public Domicilio(){}

    public Domicilio(String calle, String numero, String localidad, String provincia) {
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
        this.provincia = provincia;
    }


}
