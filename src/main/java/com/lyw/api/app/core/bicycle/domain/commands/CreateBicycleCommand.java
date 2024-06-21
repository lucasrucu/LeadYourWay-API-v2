package com.lyw.api.app.core.bicycle.domain.commands;

import com.lyw.api.app.core.bicycle.infrastructure.dto.BicycleRequestDto;

public record CreateBicycleCommand(String userId, BicycleRequestDto bicycleRequestDto) {
}
