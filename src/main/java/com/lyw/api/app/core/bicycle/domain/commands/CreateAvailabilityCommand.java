package com.lyw.api.app.core.bicycle.domain.commands;

import com.lyw.api.app.core.bicycle.infrastructure.dto.AvailabilityRequestDto;

public record CreateAvailabilityCommand(AvailabilityRequestDto availabilityRequestDto) {
}
