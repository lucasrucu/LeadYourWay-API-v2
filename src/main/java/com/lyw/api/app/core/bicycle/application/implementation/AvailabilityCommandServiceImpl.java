package com.lyw.api.app.core.bicycle.application.implementation;

import org.springframework.stereotype.Service;

import com.lyw.api.app.core.bicycle.application.services.AvailabilityCommandService;
import com.lyw.api.app.core.bicycle.domain.commands.CreateAvailabilityCommand;
import com.lyw.api.app.core.bicycle.domain.model.Availability;
import com.lyw.api.app.core.bicycle.domain.repositories.AvailabilityRepository;
import com.lyw.api.app.core.bicycle.infrastructure.dto.AvailabilityRequestDto;
import com.lyw.api.app.shared.utils.ValidationUtil;

@Service
public class AvailabilityCommandServiceImpl implements AvailabilityCommandService {

    private final AvailabilityRepository availabilityRepository;
    private final ValidationUtil validationUtil;

    public AvailabilityCommandServiceImpl(AvailabilityRepository availabilityRepository,
            ValidationUtil validationUtil) {
        this.availabilityRepository = availabilityRepository;
        this.validationUtil = validationUtil;
    }

    @Override
    public Availability handle(CreateAvailabilityCommand command) {
        Availability availability = new Availability();
        availability = setAvailability(availability, command.availabilityRequestDto());
        availability.setBicycle(validationUtil.findBicycleById(command.availabilityRequestDto().getBicycleId()));
        return availabilityRepository.save(availability);
    }

    private Availability setAvailability(Availability availability, AvailabilityRequestDto availabilityRequestDto) {
        availability.setAvailabilityStartDate(availabilityRequestDto.getAvailabilityStartDate());
        availability.setAvailabilityEndDate(availabilityRequestDto.getAvailabilityEndDate());
        return availability;
    }

}
