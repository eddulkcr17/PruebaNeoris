package com.microservice.account.controller;

import com.microservice.account.dto.AccountDto;
import com.microservice.account.exception.ExceptionHandlingService;
import com.microservice.account.service.account.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.Callable;

@RestController
@RequestMapping("/api/cuentas")
@CrossOrigin("*")
public class AccountController {
    @Autowired
    IAccountService accountService;
    @Autowired
    ExceptionHandlingService exceptionHandlingService;

    @PostMapping("save")
    public ResponseEntity<?> save(@RequestBody AccountDto cuentaDTO)  {
        Callable<?> metodo =() ->accountService.save(cuentaDTO);
        return exceptionHandlingService.handleControllerException(metodo);
    }

    @GetMapping("findAll")
    public ResponseEntity<?> findAll()
    {
        Callable<?> metodo =() ->accountService.findAll();
        return exceptionHandlingService.handleControllerException(metodo);
    }

    @GetMapping("/{idCuenta}")
    public ResponseEntity<?> findById(@PathVariable Long idCuenta) {
        Callable<?> metodo =() ->accountService.findById(idCuenta);
        return exceptionHandlingService.handleControllerException(metodo);
    }

    @PutMapping("update")
    public ResponseEntity<?> update(@RequestBody AccountDto cuentaDTO) {
        Callable<?> metodo =() ->accountService.update(cuentaDTO);
        return exceptionHandlingService.handleControllerException(metodo);
    }

    @DeleteMapping("/{idCuenta}")
    public ResponseEntity<?> deleteById(@PathVariable Long idCuenta)  {
        Callable<?> metodo =() ->accountService.deleteById(idCuenta);
        return exceptionHandlingService.handleControllerException(metodo);
    }
}
