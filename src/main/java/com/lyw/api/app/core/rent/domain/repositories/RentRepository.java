package com.lyw.api.app.core.rent.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lyw.api.app.core.rent.domain.model.Rent;

@Repository
public interface RentRepository extends JpaRepository<Rent, Long> {
}
