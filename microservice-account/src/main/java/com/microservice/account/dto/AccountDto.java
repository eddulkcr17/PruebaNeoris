package com.microservice.account.dto;

import lombok.Data;

@Data
public class AccountDto {
    private Long accountId;
    private Long accountNumber;
    private String accountType;
    private Long initialBalance;
    private String accountState;
    private Long actualBalance;
    private Long customerId;
}
