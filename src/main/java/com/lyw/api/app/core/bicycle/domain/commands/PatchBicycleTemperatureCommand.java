package com.lyw.api.app.core.bicycle.domain.commands;

public record PatchBicycleTemperatureCommand(double temperature, Long bicycleId) {
}
