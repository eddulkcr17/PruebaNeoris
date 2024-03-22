package com.microservice.customer.service;

import com.microservice.customer.entities.Client;
import com.microservice.customer.persistence.ClientRepository;
import com.microservice.customer.service.client.ClientServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.util.Assert;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class ClientServiceImplTest {

    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private ClientServiceImpl clientService;

    @Test
    public void testFindAll() {
        List<Client> clients = Arrays.asList(new Client(), new Client());
        Mockito.when(clientRepository.findAll()).thenReturn(clients);

        List<Client> result = clientService.findAll();

        Assert.assertEquals(2, result.size());
    }

    @Test
    public void testFindById() {
        Long clientId = 1L;
        Client client = new Client();
        Mockito.when(clientRepository.findById(clientId)).thenReturn(Optional.of(client));

        Client result = clientService.findById(clientId);

        Assert.assertEquals(client, result);
    }

    @Test
    public void testSave() {
        Client client = new Client();

        clientService.save(client);

        Mockito.verify(clientRepository).save(client);
    }

    @Test
    public void testDeleteById() {
        Long clientId = 1L;
        Client client = new Client();
        Mockito.when(clientRepository.findById(clientId)).thenReturn(Optional.of(client));

        clientService.deleteById(clientId);

        Mockito.verify(clientRepository).delete(client);
    }

    @Test
    public void testUpdate() {
        Long clientId = 1L;
        Client client = new Client();
        client.setPersonName("John Doe");
        client.setPersonAddress("123 Main St");
        client.setPersonPhone("555-1234");

        Client existingClient = new Client();
        existingClient.setPersonName("Jane Doe");
        existingClient.setPersonAddress("456 Elm St");
        existingClient.setPersonPhone("555-5678");

        Mockito.when(clientRepository.findById(clientId)).thenReturn(Optional.of(existingClient));
        Mockito.when(clientRepository.save(existingClient)).thenReturn(existingClient);

        Client updatedClient = clientService.update(client, clientId);

        Assert.assertEquals("John Doe",
                updatedClient.getPersonName());
        Assert.assertEquals("123 Main St", updatedClient.getPersonAddress());
        Assert.assertEquals("555-1234", updatedClient.getPersonPhone());
    }
}

