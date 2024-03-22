package com.microservice.account.service.account;

import com.microservice.account.dto.AccountDto;
import com.microservice.account.entities.Account;
import com.microservice.account.http.response.AccountByClientResponse;
import com.microservice.account.service.GenericService;

import java.util.List;

public interface IAccountService extends GenericService<AccountDto,Long> {

}
