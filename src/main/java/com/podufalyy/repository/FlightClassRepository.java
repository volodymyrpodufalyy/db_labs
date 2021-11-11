package com.podufalyy.repository;

import com.podufalyy.domain.FlightCLass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightClassRepository extends JpaRepository<FlightCLass, Integer> {
}
