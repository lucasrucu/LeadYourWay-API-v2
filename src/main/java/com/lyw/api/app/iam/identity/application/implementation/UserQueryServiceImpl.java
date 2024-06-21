package com.lyw.api.app.iam.identity.application.implementation;

import org.springframework.stereotype.Service;

import com.lyw.api.app.core.card.domain.model.Card;
import com.lyw.api.app.iam.identity.application.services.UserQueryService;
import com.lyw.api.app.iam.identity.domain.model.User;
import com.lyw.api.app.iam.identity.domain.queries.GetUserByIdQuery;
import com.lyw.api.app.iam.identity.domain.queries.GetUserMainCard;
import com.lyw.api.app.shared.utils.ValidationUtil;

@Service
public class UserQueryServiceImpl implements UserQueryService {

    private final ValidationUtil validationUtil;

    public UserQueryServiceImpl(
            ValidationUtil validationUtil) {
        this.validationUtil = validationUtil;
    }

    @Override
    public User handle(GetUserByIdQuery query) {
        return validationUtil.findUserById(query.userId());
    }

    @Override
    public Card handle(GetUserMainCard query) {
        User user = validationUtil.findUserById(query.userId());
        Card mainCard = new Card();
        for (Card card : user.getCards()) {
            if (card.getCardMain()) {
                mainCard = card;
            }
        }
        return mainCard;
    }
}
