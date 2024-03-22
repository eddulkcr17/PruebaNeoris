package com.microservice.account.mapper;

import com.microservice.account.dto.AccountDto;
import com.microservice.account.entities.Account;

public interface AccountMapper {
    Account cuentaDtoToCuenta(AccountDto accountDto);

   // AccountDto accountToAccountDto(Account account);
}
