package com.lyw.api.app.core.bicycle.infrastructure.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.lyw.api.app.core.bicycle.domain.model.Bicycle;
import com.lyw.api.app.core.bicycle.infrastructure.dto.BicycleResponseDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BicycleMapper {
    @Mappings({
            @Mapping(target = "bicycleName", source = "bicycleName"),
            @Mapping(target = "bicycleDescription", source = "bicycleDescription"),
            @Mapping(target = "bicyclePrice", source = "bicyclePrice"),
            @Mapping(target = "bicycleSize", source = "bicycleSize"),
            @Mapping(target = "bicycleModel", source = "bicycleModel"),
            @Mapping(target = "imageData", source = "imageData")
    })
    BicycleResponseDto toResponseDto(Bicycle card);

    List<BicycleResponseDto> toResponseDto(List<Bicycle> cards);
}
