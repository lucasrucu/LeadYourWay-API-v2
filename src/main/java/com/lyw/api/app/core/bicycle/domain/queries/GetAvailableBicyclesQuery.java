package com.lyw.api.app.core.bicycle.domain.queries;

import java.util.Date;

public record GetAvailableBicyclesQuery(Date startDate, Date endDate) {
}
