package com.lyw.api.app.iam.identity.infrastructure.transformation;

import com.lyw.api.app.iam.identity.domain.commands.RegisterUserRenterCommand;
import com.lyw.api.app.iam.identity.infrastructure.dto.UserRequestDto;

public class RegisterUserRenterCommandFromRequestDtoAssembler {
    public static RegisterUserRenterCommand toCommandFromDto(UserRequestDto requestDto) {
        return new RegisterUserRenterCommand(requestDto);
    }
}
