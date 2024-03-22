package com.microservice.account.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class MsjGenericoDTO implements Serializable {
    private Boolean exitoso;
    private Object data;
    private String mensajeError;
}
