package com.microservice.customer.persistence;

import com.microservice.customer.entities.Client;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface ClientRepository extends CrudRepository<Client, Long> {

}
