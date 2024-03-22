package com.microservice.account.service.movement;

import com.microservice.account.dto.AccountDto;
import com.microservice.account.dto.MovementDto;
import com.microservice.account.dto.MsjGenericoDTO;
import com.microservice.account.entities.Account;
import com.microservice.account.entities.Movements;
import com.microservice.account.http.response.AccountByClientResponse;
import com.microservice.account.service.GenericService;

import java.util.Date;
import java.util.List;

public interface IMovementService extends GenericService<MovementDto,Long> {

}



