package com.lyw.api.app.iam.identity.infrastructure.transformation;

import com.lyw.api.app.iam.identity.domain.commands.RegisterUserBikerCommand;
import com.lyw.api.app.iam.identity.infrastructure.dto.UserRequestDto;

public class RegisterUserBikerCommandFromRequestDtoAssembler {
    public static RegisterUserBikerCommand toCommandFromDto(UserRequestDto requestDto) {
        return new RegisterUserBikerCommand(requestDto);
    }
}
