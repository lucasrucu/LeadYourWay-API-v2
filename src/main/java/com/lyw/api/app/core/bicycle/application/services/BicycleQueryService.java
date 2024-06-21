package com.lyw.api.app.core.bicycle.application.services;

import java.util.List;

import com.lyw.api.app.core.bicycle.domain.model.Bicycle;
import com.lyw.api.app.core.bicycle.domain.queries.GetAvailableBicyclesQuery;
import com.lyw.api.app.core.bicycle.domain.queries.GetBicycleByIdQuery;
import com.lyw.api.app.core.bicycle.domain.queries.GetBicyclesQuery;

public interface BicycleQueryService {

    Bicycle handle(GetBicycleByIdQuery query);

    List<Bicycle> handle(GetBicyclesQuery query);

    List<Bicycle> handle(GetAvailableBicyclesQuery query);
}
