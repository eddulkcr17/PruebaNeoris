package com.microservice.account.client;

import com.microservice.account.dto.CustomerDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="msvc-customer", url = "localhost:8080/api/clientes")
public interface CustomerClient {

    @GetMapping("/shearch/{id}")
    List<CustomerDto> findCustomerById(@PathVariable Long id);
}
