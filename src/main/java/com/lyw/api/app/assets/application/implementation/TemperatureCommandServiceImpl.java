package com.lyw.api.app.assets.application.implementation;

import org.springframework.stereotype.Service;

import com.lyw.api.app.assets.application.services.TemperatureCommandService;
import com.lyw.api.app.assets.domain.commands.CreateTemperatureCommand;
import com.lyw.api.app.assets.domain.model.Temperature;
import com.lyw.api.app.assets.domain.repositories.TemperatureRepository;

@Service
public class TemperatureCommandServiceImpl implements TemperatureCommandService {

    private final TemperatureRepository temperatureRepository;

    public TemperatureCommandServiceImpl(TemperatureRepository temperatureRepository) {
        this.temperatureRepository = temperatureRepository;
    }

    @Override
    public Temperature handle(CreateTemperatureCommand command) {
        Temperature temperature = new Temperature();
        temperature.setTemperature(25.0);
        return temperatureRepository.save(temperature);
    }
}
