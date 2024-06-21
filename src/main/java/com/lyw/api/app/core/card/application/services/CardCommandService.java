package com.lyw.api.app.core.card.application.services;

import com.lyw.api.app.core.card.domain.commands.CreateCardCommand;
import com.lyw.api.app.core.card.domain.commands.DeleteCardCommand;
import com.lyw.api.app.core.card.domain.commands.UpdateCardCommand;
import com.lyw.api.app.core.card.domain.model.Card;

public interface CardCommandService {
    Card handle(CreateCardCommand command);

    Card handle(UpdateCardCommand command);

    void handle(DeleteCardCommand command);
}
