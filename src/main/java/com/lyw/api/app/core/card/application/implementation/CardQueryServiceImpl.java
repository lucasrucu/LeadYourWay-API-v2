package com.lyw.api.app.core.card.application.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lyw.api.app.core.card.application.services.CardQueryService;
import com.lyw.api.app.core.card.domain.model.Card;
import com.lyw.api.app.core.card.domain.queries.GetCardByIdQuery;
import com.lyw.api.app.core.card.domain.queries.GetCardsByUserIdQuery;
import com.lyw.api.app.core.card.domain.repositories.CardRepository;
import com.lyw.api.app.shared.utils.ValidationUtil;

@Service
public class CardQueryServiceImpl implements CardQueryService {

    private CardRepository cardRepository;
    private ValidationUtil validationUtil;

    public CardQueryServiceImpl(CardRepository cardRepository, ValidationUtil validationUtil) {
        this.cardRepository = cardRepository;
        this.validationUtil = validationUtil;
    }

    @Override
    public Card handle(GetCardByIdQuery query) {
        return validationUtil.findCardById(query.cardId());
    }

    @Override
    public List<Card> handle(GetCardsByUserIdQuery query) {
        return cardRepository.findByUserId(query.userId());
    }

}
