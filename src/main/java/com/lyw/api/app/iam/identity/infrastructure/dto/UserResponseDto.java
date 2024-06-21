package com.lyw.api.app.iam.identity.infrastructure.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "Usuario (Response)")
public class UserResponseDto {
    @Schema(description = "User id")
    private String id;
    @Schema(description = "User name")
    private String name;
    @Schema(description = "Role")
    private String role;
}
