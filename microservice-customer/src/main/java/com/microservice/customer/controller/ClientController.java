package com.microservice.customer.controller;

import com.microservice.customer.entities.Client;
import com.microservice.customer.service.client.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/clientes")
public class ClientController {

    @Autowired
    private IClientService clientService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveClient(@RequestBody Client client){
        clientService.save(client);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAllClients(){
        return ResponseEntity.ok(clientService.findAll());
    }

    @GetMapping("/shearch/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return ResponseEntity.ok(clientService.findById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateClient(@PathVariable Long id, @RequestBody Client client){
        Optional<Client> clientOptional = Optional.ofNullable(clientService.findById(id));
        if (clientOptional.isPresent()){
            Client clientNew = clientOptional.get();
            clientNew.setPersonPhone(client.getPersonPhone());
            clientNew.setPersonAddress(client.getPersonAddress());
            clientService.save(clientNew);
            return ResponseEntity.ok("registro actualizado");
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        if (id != null){
            clientService.deleteById(id);
            return ResponseEntity.ok("registro eliminado");
        }
        return ResponseEntity.notFound().build();
    }

}
