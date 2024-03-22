package com.microservice.customer.service.client;

import com.microservice.customer.entities.Client;
import com.microservice.customer.persistence.ClientRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements IClientService{

    private ClientRepository clientRepository;

    @Override
    public List<Client> findAll() {
        return (List<Client>) clientRepository.findAll();
    }
    @Override
    public Client findById(Long id) {
        return clientRepository.findById(id).orElseThrow();
    }

    @Override
    public void save(Client client) {
        clientRepository.save(client);
    }
    @Override
    public void deleteById(Long id) {
        Client clienteExiste = clientRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("CLiente no encontrado"));

         clientRepository.delete(clienteExiste);
    }

    public Client update(Client client, Long id) {
        Client clienteExiste = clientRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("CLiente no encontrado"));

        clienteExiste.setPersonName(client.getPersonName());
        clienteExiste.setPersonAddress(client.getPersonAddress());
        clienteExiste.setPersonPhone(client.getPersonPhone());

        return clientRepository.save(clienteExiste);
    }
}
