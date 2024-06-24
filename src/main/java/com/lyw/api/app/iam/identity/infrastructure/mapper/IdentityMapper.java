package com.lyw.api.app.iam.identity.infrastructure.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

import com.lyw.api.app.assets.domain.model.Temperature;
import com.lyw.api.app.core.bicycle.domain.model.Bicycle;
import com.lyw.api.app.core.bicycle.infrastructure.dto.BicycleResponseDto;
import com.lyw.api.app.iam.identity.domain.model.User;
import com.lyw.api.app.iam.identity.infrastructure.dto.UserProfileResponseDto;
import com.lyw.api.app.iam.identity.infrastructure.dto.UserResponseDto;

@Mapper(componentModel = "spring")
public interface IdentityMapper {
    @Mappings({
            @Mapping(target = "id", source = "entity.id"),
            @Mapping(target = "name", source = "entity.googleName"),
            @Mapping(target = "role", source = "entity.role.name"),
    })
    UserResponseDto userToResponseDto(User entity);

    @Mappings({
            @Mapping(target = "name", source = "entity.googleName"),
            @Mapping(target = "email", source = "entity.email"),
            @Mapping(target = "photoUrl", source = "entity.googlePhotoUrl"),
            @Mapping(target = "bicycles", source = "entity.bicycles", qualifiedByName = "mapBicycles"),
            @Mapping(target = "cards", source = "entity.cards"),
    })
    UserProfileResponseDto userToProfileResponseDto(User entity);

    @Named("mapTemperature")
    default double mapTemperature(Temperature temperature) {
        return temperature.getTemperature();
    }

    @Named("mapBicycles")
    default List<BicycleResponseDto> mapBicycles(List<Bicycle> bicycles) {
        if (bicycles == null) {
            return null;
        }

        return bicycles.stream()
                .map(bicycle -> {
                    BicycleResponseDto dto = new BicycleResponseDto();
                    dto.setId(bicycle.getId());
                    dto.setBicycleName(bicycle.getBicycleName());
                    dto.setBicycleDescription(bicycle.getBicycleDescription());
                    dto.setBicyclePrice(bicycle.getBicyclePrice());
                    dto.setBicycleSize(bicycle.getBicycleSize());
                    dto.setBicycleModel(bicycle.getBicycleModel());
                    dto.setImageData(bicycle.getImageData());
                    dto.setTemperature(mapTemperature(bicycle.getTemperature()));
                    return dto;
                })
                .toList();
    }

}
