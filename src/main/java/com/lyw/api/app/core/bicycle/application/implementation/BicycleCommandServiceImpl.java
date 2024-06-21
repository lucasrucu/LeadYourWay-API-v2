package com.lyw.api.app.core.bicycle.application.implementation;

import org.springframework.stereotype.Service;

import com.lyw.api.app.core.bicycle.application.services.BicycleCommandService;
import com.lyw.api.app.core.bicycle.domain.commands.CreateBicycleCommand;
import com.lyw.api.app.core.bicycle.domain.commands.DeleteBicycleCommand;
import com.lyw.api.app.core.bicycle.domain.commands.UpdateBicycleCommand;
import com.lyw.api.app.core.bicycle.domain.model.Bicycle;
import com.lyw.api.app.core.bicycle.domain.repositories.BicycleRepository;
import com.lyw.api.app.core.bicycle.infrastructure.dto.BicycleRequestDto;
import com.lyw.api.app.shared.utils.ValidationUtil;

@Service
public class BicycleCommandServiceImpl implements BicycleCommandService {

    private final BicycleRepository bicycleRepository;
    private final ValidationUtil validationUtil;

    public BicycleCommandServiceImpl(BicycleRepository bicycleRepository, ValidationUtil validationUtil) {
        this.bicycleRepository = bicycleRepository;
        this.validationUtil = validationUtil;
    }

    @Override
    public Bicycle handle(CreateBicycleCommand command) {
        Bicycle bicycle = new Bicycle();
        bicycle = setBicycle(bicycle, command.bicycleRequestDto());
        bicycle.setUser(validationUtil.findUserById(command.userId()));
        return bicycleRepository.save(bicycle);
    }

    @Override
    public Bicycle handle(UpdateBicycleCommand command) {
        Bicycle bicycle = validationUtil.findBicycleById(command.bicycleId());
        bicycle = setBicycle(bicycle, command.bicycleRequestDto());
        return bicycleRepository.save(bicycle);
    }

    @Override
    public void handle(DeleteBicycleCommand command) {
        Bicycle bicycle = validationUtil.findBicycleById(command.bicycleId());
        bicycleRepository.delete(bicycle);
    }

    private Bicycle setBicycle(Bicycle bicycle, BicycleRequestDto bicycleRequestDto) {
        bicycle.setBicycleName(bicycleRequestDto.getBicycleName());
        bicycle.setBicycleDescription(bicycleRequestDto.getBicycleDescription());
        bicycle.setBicyclePrice(bicycleRequestDto.getBicyclePrice());
        bicycle.setBicycleSize(bicycleRequestDto.getBicycleSize());
        bicycle.setBicycleModel(bicycleRequestDto.getBicycleModel());
        bicycle.setImageData(bicycleRequestDto.getImageData());
        return bicycle;
    }
}
