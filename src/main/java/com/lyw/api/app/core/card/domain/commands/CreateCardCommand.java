package com.lyw.api.app.core.card.domain.commands;

import com.lyw.api.app.core.card.infrastructure.dto.CardRequestDto;

public record CreateCardCommand(String userId, CardRequestDto cardRequestDto) {
}
