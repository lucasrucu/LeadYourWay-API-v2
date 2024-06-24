package com.lyw.api.app.core.rent.infrastructure.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lyw.api.app.core.rent.application.services.RentCommandService;
import com.lyw.api.app.core.rent.domain.commands.CreateRentCommand;
import com.lyw.api.app.core.rent.infrastructure.dto.RentRequestDto;
import com.lyw.api.app.core.rent.infrastructure.dto.RentResponseDto;
import com.lyw.api.app.core.rent.infrastructure.mapper.RentMapper;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/leadyourway/v1/rent")
@Tag(name = "Rent Controller", description = "Rent API")
@CrossOrigin
public class RentController {

    private final RentCommandService rentCommandService;
    private final RentMapper rentMapper;

    public RentController(RentCommandService rentCommandService, RentMapper rentMapper) {
        this.rentCommandService = rentCommandService;
        this.rentMapper = rentMapper;
    }

    @Transactional
    @PostMapping
    @Operation(summary = "Create a rent")
    public ResponseEntity<RentResponseDto> createRent(@RequestBody RentRequestDto rentRequestDto) {
        return ResponseEntity
                .ok(rentMapper.toResponseDto(rentCommandService.handle(new CreateRentCommand(rentRequestDto))));
    }
}
