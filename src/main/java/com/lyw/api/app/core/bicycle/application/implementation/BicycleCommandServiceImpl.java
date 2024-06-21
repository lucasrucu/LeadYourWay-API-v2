package com.lyw.api.app.core.bicycle.application.implementation;

import org.springframework.stereotype.Service;

import com.lyw.api.app.assets.application.services.TemperatureCommandService;
import com.lyw.api.app.assets.domain.commands.CreateTemperatureCommand;
import com.lyw.api.app.assets.domain.model.Temperature;
import com.lyw.api.app.core.bicycle.application.services.BicycleCommandService;
import com.lyw.api.app.core.bicycle.domain.commands.CreateBicycleCommand;
import com.lyw.api.app.core.bicycle.domain.commands.DeleteBicycleCommand;
import com.lyw.api.app.core.bicycle.domain.commands.PatchBicycleTemperatureCommand;
import com.lyw.api.app.core.bicycle.domain.commands.UpdateBicycleCommand;
import com.lyw.api.app.core.bicycle.domain.model.Bicycle;
import com.lyw.api.app.core.bicycle.domain.repositories.BicycleRepository;
import com.lyw.api.app.core.bicycle.infrastructure.dto.BicycleRequestDto;
import com.lyw.api.app.shared.utils.ValidationUtil;

@Service
public class BicycleCommandServiceImpl implements BicycleCommandService {

    private final BicycleRepository bicycleRepository;
    private final TemperatureCommandService temperatureService;
    private final ValidationUtil validationUtil;

    public BicycleCommandServiceImpl(BicycleRepository bicycleRepository,
            TemperatureCommandService temperatureCommandService, ValidationUtil validationUtil) {
        this.bicycleRepository = bicycleRepository;
        this.validationUtil = validationUtil;
        this.temperatureService = temperatureCommandService;
    }

    @Override
    public Bicycle handle(CreateBicycleCommand command) {
        Bicycle bicycle = new Bicycle();
        bicycle = setBicycle(bicycle, command.bicycleRequestDto());
        bicycle.setUser(validationUtil.findUserById(command.userId()));
        bicycle.setTemperature(temperatureService.handle(new CreateTemperatureCommand()));
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

    @Override
    public Temperature handle(PatchBicycleTemperatureCommand command) {
        Bicycle bicycle = validationUtil.findBicycleById(command.bicycleId());
        Temperature temperature = new Temperature();
        temperature.setTemperature(command.temperature());
        bicycle.setTemperature(temperature);
        return temperature;
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
