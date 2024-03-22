package com.microservice.customer.service.client;

import com.microservice.customer.entities.Client;

import java.util.List;

public interface IClientService {

    List<Client> findAll();
    Client findById(Long id);
    void save(Client client);

    void deleteById(Long id);

    Client update(Client client, Long id);


}
