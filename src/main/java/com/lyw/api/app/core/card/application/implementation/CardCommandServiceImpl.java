package com.lyw.api.app.core.card.application.implementation;

import org.springframework.stereotype.Service;

import com.lyw.api.app.core.card.application.services.CardCommandService;
import com.lyw.api.app.core.card.domain.commands.CreateCardCommand;
import com.lyw.api.app.core.card.domain.commands.DeleteCardCommand;
import com.lyw.api.app.core.card.domain.commands.UpdateCardAmountCommand;
import com.lyw.api.app.core.card.domain.commands.UpdateCardCommand;
import com.lyw.api.app.core.card.domain.model.Card;
import com.lyw.api.app.core.card.domain.repositories.CardRepository;
import com.lyw.api.app.core.card.infrastructure.dto.CardRequestDto;
import com.lyw.api.app.shared.utils.ValidationUtil;

import jakarta.transaction.Transactional;

@Service
public class CardCommandServiceImpl implements CardCommandService {

    private final CardRepository cardRepository;
    private final ValidationUtil validationUtil;

    public CardCommandServiceImpl(CardRepository cardRepository, ValidationUtil validationUtil) {
        this.cardRepository = cardRepository;
        this.validationUtil = validationUtil;
    }

    @Override
    public Card handle(CreateCardCommand command) {
        Card card = new Card();
        card = setCard(card, command.cardRequestDto());
        card.setUser(validationUtil.findUserById(command.userId()));
        return cardRepository.save(card);
    }

    @Override
    public Card handle(UpdateCardCommand command) {
        Card card = validationUtil.findCardById(command.cardId());
        card = setCard(card, command.cardRequestDto());
        return cardRepository.save(card);
    }

    @Override
    public void handle(DeleteCardCommand command) {
        Card card = validationUtil.findCardById(command.cardId());
        cardRepository.delete(card);
    }

    @Override
    @Transactional
    public void handle(UpdateCardAmountCommand command) {
        Card card = validationUtil.findCardById(command.cardId());
        card.setCardAmount(card.getCardAmount() + command.amount());
        cardRepository.save(card);
    }

    private Card setCard(Card card, CardRequestDto cardDto) {
        card.setCardNumber(cardDto.getCardNumber());
        card.setCardType(cardDto.getCardType());
        card.setCardCvv(cardDto.getCardCvv());
        card.setCardExpirationDate(cardDto.getCardExpirationDate());
        card.setCardAmount(cardDto.getCardAmount());
        card.setCardHolder(cardDto.getCardHolder());
        card.setCardMain(cardDto.isCardMain());
        return card;
    }

}
