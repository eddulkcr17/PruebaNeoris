package com.microservice.account.mapper;

import com.microservice.account.dto.MovementDto;
import com.microservice.account.entities.Movements;

public interface MovementMapper {
    Movements movementDtoToMovement(MovementDto movementDto);

    MovementDto movementToMovementDto(Movements movements);
}
