package com.lyw.api.app.core.bicycle.domain.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lyw.api.app.core.bicycle.domain.model.Availability;

@Repository
public interface AvailabilityRepository extends JpaRepository<Availability, Long> {
    List<Availability> findByBicycleId(Long bicycle_id);
}
