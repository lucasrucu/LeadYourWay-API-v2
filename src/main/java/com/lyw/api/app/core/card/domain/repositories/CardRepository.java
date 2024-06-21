package com.lyw.api.app.core.card.domain.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lyw.api.app.core.card.domain.model.Card;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
    Optional<Card> findByUserIdAndCardMain(String userId, boolean cardMain);

    List<Card> findByUserId(String userId);
}
