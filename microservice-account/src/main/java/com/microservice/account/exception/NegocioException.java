package com.microservice.account.exception;

public class NegocioException extends Exception{
    public static  final String ERROR_GENERAL = "No se pudo procesar la transaccion";
    public NegocioException(String message){super(message);}
}
