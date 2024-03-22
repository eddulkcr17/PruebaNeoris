package com.microservice.customer.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
public class Person {

    @Id
    @Column(name = "id_cliente",updatable = false,nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientId;
    @Column(name = "identificacion", nullable = false)
    private String personDNI;
    @Column(name = "nombre", nullable = false)
    private String personName;
    @Column(name = "genero")
    private String personGenre;
    @Column(name = "edad")
    private Integer personAge;
    @Column(name = "direccion")
    private String personAddress;
    @Column(name = "telefono")
    private String personPhone;

}
