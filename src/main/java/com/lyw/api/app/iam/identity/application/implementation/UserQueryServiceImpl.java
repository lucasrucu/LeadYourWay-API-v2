package com.lyw.api.app.iam.identity.application.implementation;

import org.springframework.stereotype.Service;

import com.google.firebase.database.utilities.Validation;
import com.lyw.api.app.core.card.application.services.CardQueryService;
import com.lyw.api.app.core.card.domain.model.Card;
import com.lyw.api.app.core.card.domain.queries.GetCardByUserIdAndCardMainQuery;
import com.lyw.api.app.iam.identity.application.services.UserQueryService;
import com.lyw.api.app.iam.identity.domain.model.User;
import com.lyw.api.app.iam.identity.domain.queries.GetUserByIdQuery;
import com.lyw.api.app.iam.identity.domain.queries.GetUserMainCard;
import com.lyw.api.app.shared.utils.ValidationUtil;

@Service
public class UserQueryServiceImpl implements UserQueryService {

    private final CardQueryService cardQueryService;
    private final ValidationUtil validationUtil;

    public UserQueryServiceImpl(CardQueryService cardQueryService,
            ValidationUtil validationUtil) {
        this.validationUtil = validationUtil;
        this.cardQueryService = cardQueryService;
    }

    @Override
    public User handle(GetUserByIdQuery query) {
        return validationUtil.findUserById(query.userId());
    }

    @Override
    public Card handle(GetUserMainCard query) {
        User user = validationUtil.findUserById(query.userId());
        return cardQueryService.handle(new GetCardByUserIdAndCardMainQuery(user.getId(), true));
    }
}
