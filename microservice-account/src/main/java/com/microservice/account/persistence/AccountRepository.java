package com.microservice.account.persistence;

import com.microservice.account.entities.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {

//    @Query("SELECT a FROM cuentas a WHERE s.cliente_id = :userId")
//    List<Account> findAllByUserId(Long userId);
}
