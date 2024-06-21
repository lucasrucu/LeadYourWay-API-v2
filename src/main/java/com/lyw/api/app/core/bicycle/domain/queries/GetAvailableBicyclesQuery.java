package com.lyw.api.app.core.bicycle.domain.queries;

import java.time.LocalDate;

public record GetAvailableBicyclesQuery(LocalDate startDate, LocalDate endDate) {
}
