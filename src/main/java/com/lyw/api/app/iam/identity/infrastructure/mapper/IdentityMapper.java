package com.lyw.api.app.iam.identity.infrastructure.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.lyw.api.app.iam.identity.domain.model.User;
import com.lyw.api.app.iam.identity.infrastructure.dto.UserResponseDto;

@Mapper(componentModel = "spring")
public interface IdentityMapper {
    @Mappings({
            @Mapping(target = "id", source = "entity.id"),
            @Mapping(target = "name", source = "entity.googleName"),
            @Mapping(target = "role", source = "entity.role.name"),
    })
    UserResponseDto userToResponseDto(User entity);

}
