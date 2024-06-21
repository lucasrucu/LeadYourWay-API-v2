package com.lyw.api.app.core.rent.infrastructure.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "Rent (Request)")
public class RentResponseDto {
    @Schema(description = "Rent Start Date")
    private String rentStartDate;
    @Schema(description = "Rent End Date")
    private String rentEndDate;
    @Schema(description = "Rent Price")
    private double rentPrice;
    @Schema(description = "Bicycle Id")
    private Long bicycleId;
    @Schema(description = "Card Id")
    private Long cardId;
}
