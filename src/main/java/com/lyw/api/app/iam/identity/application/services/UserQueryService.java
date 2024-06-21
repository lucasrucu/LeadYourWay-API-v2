package com.lyw.api.app.iam.identity.application.services;

import com.lyw.api.app.iam.identity.domain.model.User;
import com.lyw.api.app.iam.identity.domain.queries.GetUserByIdQuery;

public interface UserQueryService {

    User handle(GetUserByIdQuery query);
}
