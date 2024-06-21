package com.lyw.api.app.core.card.infrastructure.dto;

import java.util.Date;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "Card (Response)")
public class CardResponseDto {
    @Schema(description = "Card Number")
    private String cardNumber;
    @Schema(description = "Card Type")
    private String cardType;
    @Schema(description = "Card CVV")
    private String cardCvv;
    @Schema(description = "Card Expiration Date")
    private Date cardExpirationDate;
    @Schema(description = "Card Amount")
    private Double cardAmount;
    @Schema(description = "Card Holder")
    private String cardHolder;
    @Schema(description = "Card Main")
    private boolean cardMain;
}