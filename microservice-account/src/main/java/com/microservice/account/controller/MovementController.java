package com.microservice.account.controller;

import com.microservice.account.dto.MovementDto;
import com.microservice.account.exception.ExceptionHandlingService;
import com.microservice.account.service.movement.IMovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.concurrent.Callable;

@RestController
@RequestMapping("/api/movimientos")
@CrossOrigin("*")
public class MovementController {

    @Autowired
    IMovementService movementService;
    @Autowired
    ExceptionHandlingService exceptionHandlingService;

    @PostMapping("save")
    public ResponseEntity<?> save(@RequestBody MovementDto movimeintoDTO) {
        Callable<?> metodo =() ->movementService.save(movimeintoDTO);
        return exceptionHandlingService.handleControllerException(metodo);
    }

    @GetMapping("findAll")
    public ResponseEntity<?> findAll() {
        Callable<?> metodo =() ->movementService.findAll();
        return exceptionHandlingService.handleControllerException(metodo);
    }

    @GetMapping("/{idMovimiento}")
    public ResponseEntity<?> findById(@PathVariable Long idMovimiento)  {
        Callable<?> metodo =() ->movementService.findById(idMovimiento);
        return exceptionHandlingService.handleControllerException(metodo);
    }

    @PutMapping("update")
    public ResponseEntity<?> update(@RequestBody MovementDto movimeintoDTO) {
        Callable<?> metodo =() ->movementService.update(movimeintoDTO);
        return exceptionHandlingService.handleControllerException(metodo);
    }

    @DeleteMapping("/{idMovimiento}")
    public ResponseEntity<?> deleteById(@PathVariable Long idMovimiento) {
        Callable<?> metodo =() ->movementService.deleteById(idMovimiento);
        return exceptionHandlingService.handleControllerException(metodo);
    }

    @GetMapping("/report/{fechaInicio}/{fechaFin}")
    public ResponseEntity<?> filtrarPorFecha(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaInicio, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaFin)  {
        Callable<?> metodo =() ->movementService.filtrarPorFecha(fechaInicio,fechaFin);
        return exceptionHandlingService.handleControllerException(metodo);
    }
}
