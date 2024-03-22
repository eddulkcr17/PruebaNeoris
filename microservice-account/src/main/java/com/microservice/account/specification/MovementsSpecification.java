package com.microservice.account.specification;

import com.microservice.account.entities.Movements;
import org.springframework.data.jpa.domain.Specification;

import java.util.Date;

public class MovementsSpecification {
    public static Specification<Movements> filtroFechas(Date fechaInicio, Date fechaFin){
        return (root,query,builder)->{
            if(fechaInicio != null && fechaFin != null){
                return builder.between(root.get("fecha"), fechaInicio, fechaFin);
            }
            return null;
        };
    }
}
