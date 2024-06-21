package com.lyw.api.app.core.bicycle.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lyw.api.app.core.bicycle.domain.model.Bicycle;

@Repository
public interface CardRepository extends JpaRepository<Bicycle, Long> {
}
