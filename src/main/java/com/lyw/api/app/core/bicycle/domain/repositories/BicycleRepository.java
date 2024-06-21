package com.lyw.api.app.core.bicycle.domain.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lyw.api.app.core.bicycle.domain.model.Bicycle;

@Repository
public interface BicycleRepository extends JpaRepository<Bicycle, Long> {
        @Query("SELECT b FROM Bicycle b WHERE NOT EXISTS (" +
                        "SELECT a FROM Availability a WHERE a.bicycle.id = b.id " +
                        "AND ((a.availabilityStartDate <= :endDate AND a.availabilityEndDate >= :startDate)" +
                        "OR (a.availabilityStartDate <= :endDate AND a.availabilityStartDate >= :startDate)" +
                        "OR (a.availabilityEndDate >= :startDate AND a.availabilityEndDate <= :endDate)))")
        List<Bicycle> findAvailableBicycles(
                        @Param("startDate") LocalDate startDate,
                        @Param("endDate") LocalDate endDate);
}
