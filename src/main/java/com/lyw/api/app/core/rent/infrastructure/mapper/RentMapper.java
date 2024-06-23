package com.lyw.api.app.core.rent.infrastructure.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.lyw.api.app.core.rent.domain.model.Rent;
import com.lyw.api.app.core.rent.infrastructure.dto.RentResponseDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RentMapper {
    @Mappings({
            @Mapping(target = "rentStartDate", source = "rentStartDate"),
            @Mapping(target = "rentEndDate", source = "rentEndDate"),
            @Mapping(target = "rentPrice", source = "rentPrice"),
            @Mapping(target = "bicycleId", source = "bicycleId"),
            @Mapping(target = "cardId", source = "cardId")
    })
    RentResponseDto toResponseDto(Rent rent);

    List<RentResponseDto> toResponseDto(List<Rent> rents);
}
