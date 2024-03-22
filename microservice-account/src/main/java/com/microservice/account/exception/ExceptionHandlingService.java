package com.microservice.account.exception;

import com.microservice.account.dto.MsjGenericoDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;

import java.util.concurrent.Callable;

public class ExceptionHandlingService {
    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandlingService.class);

    public static ResponseEntity<?> handleControllerException(Callable<?> metodo){
        MsjGenericoDTO msjGenericoDTO =new MsjGenericoDTO();
        try{
            msjGenericoDTO.setData(metodo.call());
            msjGenericoDTO.setExitoso(true);
        }catch (NegocioException err){
            logger.error("Error negocio", err);
            msjGenericoDTO.setExitoso(false);
            msjGenericoDTO.setMensajeError(err.getMessage());
        }
        catch (Exception err){
            logger.error("Error general", err);
            msjGenericoDTO.setExitoso(false);
            msjGenericoDTO.setMensajeError(NegocioException.ERROR_GENERAL);
        }
        return ResponseEntity.ok(msjGenericoDTO);
    }
}
