package com.lyw.api.app.core.bicycle.infrastructure.dto;

import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "Availability (Request)")
public class AvailabilityRequestDto {
    @Schema(description = "Bicycle Id")
    private Long bicycleId;
    @Schema(description = "Availability Start Date")
    private LocalDate availabilityStartDate;
    @Schema(description = "Availability End Date")
    private LocalDate availabilityEndDate;
}
