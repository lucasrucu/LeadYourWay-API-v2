package com.lyw.api.app.core.bicycle.application.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lyw.api.app.core.bicycle.application.services.BicycleQueryService;
import com.lyw.api.app.core.bicycle.domain.model.Bicycle;
import com.lyw.api.app.core.bicycle.domain.queries.GetAvailableBicyclesQuery;
import com.lyw.api.app.core.bicycle.domain.queries.GetBicycleByIdQuery;
import com.lyw.api.app.core.bicycle.domain.queries.GetBicyclesQuery;
import com.lyw.api.app.core.bicycle.domain.repositories.BicycleRepository;
import com.lyw.api.app.shared.utils.ValidationUtil;

@Service
public class BicycleQueryServiceImpl implements BicycleQueryService {

    private final BicycleRepository bicycleRepository;
    private final ValidationUtil validationUtil;

    public BicycleQueryServiceImpl(BicycleRepository bicycleRepository, ValidationUtil validationUtil) {
        this.bicycleRepository = bicycleRepository;
        this.validationUtil = validationUtil;
    }

    @Override
    public Bicycle handle(GetBicycleByIdQuery query) {
        return validationUtil.findBicycleById(query.bicycleId());
    }

    @Override
    public List<Bicycle> handle(GetBicyclesQuery query) {
        return bicycleRepository.findAll();
    }

    @Override
    public List<Bicycle> handle(GetAvailableBicyclesQuery query) {
        return bicycleRepository.findAvailableBicycles(query.startDate(), query.endDate());
    }

}
