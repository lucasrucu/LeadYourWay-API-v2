package com.lyw.api.app.core.card.domain.commands;

import com.lyw.api.app.core.card.infrastructure.dto.CardRequestDto;

public record UpdateCardCommand(Long cardId, CardRequestDto cardRequestDto) {
}
