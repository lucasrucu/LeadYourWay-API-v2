package com.lyw.api.app.core.bicycle.domain.model;

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
@Table(name = "availabilities")
public class Availability extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "availability_start_date", nullable = false)
    private LocalDate availabilityStartDate;

    @Column(name = "availability_end_date", nullable = false)
    private LocalDate availabilityEndDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bicycle_id")
    private Bicycle bicycle;
}
