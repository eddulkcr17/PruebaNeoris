package com.microservice.account.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
    private Long idCliente;
    private String nombre;
    private String contrasena;
    private String direccion;
    private String telefono;
    private String identificacion;
    private String genero;
    private Integer edad;
    private String estado;
}
