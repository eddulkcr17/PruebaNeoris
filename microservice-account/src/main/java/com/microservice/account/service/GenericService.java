package com.microservice.account.service;

import com.microservice.account.dto.MsjGenericoDTO;
import com.microservice.account.http.response.AccountByClientResponse;

import java.util.Date;

public interface GenericService <T,ID>{
    public MsjGenericoDTO findAll();

    public MsjGenericoDTO findById(ID id);

    public  MsjGenericoDTO save(T entity) throws Exception;

    public  MsjGenericoDTO update(T entity) throws Exception;

    public  MsjGenericoDTO deleteById(ID id) throws Exception;

    public  MsjGenericoDTO validate(T entity) throws Exception;
    AccountByClientResponse findAccountByClient(Long idCLient);

    public MsjGenericoDTO filtrarPorFecha(Date fechaInicio, Date fechaFin);
}
