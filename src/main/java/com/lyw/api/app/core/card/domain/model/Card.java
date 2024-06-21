package com.lyw.api.app.core.card.domain.model;

import com.lyw.api.app.iam.identity.domain.model.User;
import com.lyw.api.app.shared.model.AuditModel;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "cards")
public class Card extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "card_number", nullable = false)
    private String cardNumber;

    @Column(name = "card_type", nullable = false)
    private String cardType;

    @Column(name = "card_cvv", nullable = false)
    private String cardCvv;

    @Column(name = "card_expiration_date", nullable = false)
    private LocalDate cardExpirationDate;

    @Column(name = "card_amount", nullable = false)
    private Double cardAmount;

    @Column(name = "card_holder", nullable = false)
    private String cardHolder;

    @Column(name = "card_main", nullable = false)
    private boolean cardMain;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public boolean getCardMain() {
        return cardMain;
    }
}
