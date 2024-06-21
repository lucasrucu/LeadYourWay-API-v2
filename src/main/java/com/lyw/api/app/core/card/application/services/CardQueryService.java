package com.lyw.api.app.core.card.application.services;

import java.util.List;

import com.lyw.api.app.core.card.domain.model.Card;
import com.lyw.api.app.core.card.domain.queries.GetCardByIdQuery;
import com.lyw.api.app.core.card.domain.queries.GetCardsByUserIdQuery;

public interface CardQueryService {
    Card handle(GetCardByIdQuery query);

    List<Card> handle(GetCardsByUserIdQuery query);
}
