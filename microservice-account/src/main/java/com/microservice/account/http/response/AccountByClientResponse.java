package com.microservice.account.http.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountByClientResponse {
    private String numeroCuenta;
    private String tipoCuenta;
    private String saldoInicial;
    private String estado;
    private String nombreCliente;
    private Long clienteId;
}
