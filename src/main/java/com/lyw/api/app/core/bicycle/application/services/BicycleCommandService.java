package com.lyw.api.app.core.bicycle.application.services;

import com.lyw.api.app.assets.domain.model.Temperature;
import com.lyw.api.app.core.bicycle.domain.commands.CreateBicycleCommand;
import com.lyw.api.app.core.bicycle.domain.commands.DeleteBicycleCommand;
import com.lyw.api.app.core.bicycle.domain.commands.PatchBicycleTemperatureCommand;
import com.lyw.api.app.core.bicycle.domain.commands.UpdateBicycleCommand;
import com.lyw.api.app.core.bicycle.domain.model.Bicycle;

public interface BicycleCommandService {
    Bicycle handle(CreateBicycleCommand command);

    Bicycle handle(UpdateBicycleCommand command);

    Temperature handle(PatchBicycleTemperatureCommand command);

    void handle(DeleteBicycleCommand command);
}
