package com.lyw.api.app.core.rent.domain.model;

import com.lyw.api.app.core.bicycle.domain.model.Bicycle;
import com.lyw.api.app.core.card.domain.model.Card;
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
@Table(name = "rents")
public class Rent extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "rent_start_date", nullable = false)
    private LocalDate rentStartDate;

    @Column(name = "rent_end_date", nullable = false)
    private LocalDate rentEndDate;

    @Column(name = "rent_price", nullable = false)
    private Double rentPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bicycle_id")
    private Bicycle bicycle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "card_id")
    private Card card;
}
