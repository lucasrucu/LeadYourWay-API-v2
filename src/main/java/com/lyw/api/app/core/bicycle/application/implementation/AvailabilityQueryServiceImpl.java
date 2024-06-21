package com.lyw.api.app.core.bicycle.application.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lyw.api.app.core.bicycle.application.services.AvailabilityQueryService;
import com.lyw.api.app.core.bicycle.domain.model.Availability;
import com.lyw.api.app.core.bicycle.domain.queries.GetAvailabilitiesByBicycleIdQuery;
import com.lyw.api.app.core.bicycle.domain.repositories.AvailabilityRepository;

@Service
public class AvailabilityQueryServiceImpl implements AvailabilityQueryService {

    private final AvailabilityRepository availabilityRepository;

    public AvailabilityQueryServiceImpl(AvailabilityRepository availabilityRepository) {
        this.availabilityRepository = availabilityRepository;
    }

    @Override
    public List<Availability> handle(GetAvailabilitiesByBicycleIdQuery query) {
        return availabilityRepository.findByBicycleId(query.bicycleId());
    }

}
