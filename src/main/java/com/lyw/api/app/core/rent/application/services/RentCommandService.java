package com.lyw.api.app.core.rent.application.services;

import com.lyw.api.app.core.rent.domain.commands.CreateRentCommand;
import com.lyw.api.app.core.rent.domain.model.Rent;

public interface RentCommandService {
    Rent handle(CreateRentCommand command);
}
