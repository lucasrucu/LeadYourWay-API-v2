package com.lyw.api.app.core.bicycle.application.services;

import java.util.List;

import com.lyw.api.app.core.bicycle.domain.model.Availability;
import com.lyw.api.app.core.bicycle.domain.queries.GetAvailabilitiesByBicycleIdQuery;

public interface AvailabilityQueryService {
    List<Availability> handle(GetAvailabilitiesByBicycleIdQuery query);
}
