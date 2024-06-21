package com.lyw.api.app.iam.identity.domain.commands;

import com.lyw.api.app.iam.identity.infrastructure.dto.UserRequestDto;

public record RegisterUserRenterCommand(UserRequestDto userRequestDto) {
}
