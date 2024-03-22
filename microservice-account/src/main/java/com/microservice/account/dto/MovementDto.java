package com.microservice.account.dto;

import lombok.Data;

import java.util.Date;

@Data
public class MovementDto {
    private Long movementId;
    private Date fecha;
    private String movementType;
    private Long valor;
    private Long saldo;
    private String estado;
    private AccountDto cuenta;
}
