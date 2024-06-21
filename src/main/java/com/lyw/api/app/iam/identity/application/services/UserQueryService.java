package com.lyw.api.app.iam.identity.application.services;

import com.lyw.api.app.core.card.domain.model.Card;
import com.lyw.api.app.iam.identity.domain.model.User;
import com.lyw.api.app.iam.identity.domain.queries.GetUserByIdQuery;
import com.lyw.api.app.iam.identity.domain.queries.GetUserMainCard;

public interface UserQueryService {
    User handle(GetUserByIdQuery query);

    Card handle(GetUserMainCard query);
}
