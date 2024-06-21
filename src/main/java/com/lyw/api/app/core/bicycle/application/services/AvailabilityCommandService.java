package com.lyw.api.app.core.bicycle.application.services;

import com.lyw.api.app.core.bicycle.domain.commands.CreateAvailabilityCommand;
import com.lyw.api.app.core.bicycle.domain.model.Availability;

public interface AvailabilityCommandService {
    Availability handle(CreateAvailabilityCommand command);
}
