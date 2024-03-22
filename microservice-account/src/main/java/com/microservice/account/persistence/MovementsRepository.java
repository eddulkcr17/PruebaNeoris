package com.microservice.account.persistence;

import com.microservice.account.entities.Account;
import com.microservice.account.entities.Movements;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface MovementsRepository extends CrudRepository<Movements, Long> {
       Optional<Object> findAll(Specification<Movements> specification);
}
