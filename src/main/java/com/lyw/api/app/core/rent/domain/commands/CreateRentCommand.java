package com.lyw.api.app.core.rent.domain.commands;

import com.lyw.api.app.core.rent.infrastructure.dto.RentRequestDto;

public record CreateRentCommand(RentRequestDto rentRequestDto) {
}
