package com.podufalyy.service;

import com.podufalyy.domain.Flight;
import com.podufalyy.repository.FlightRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class FlightService extends AbstractService<Flight, Integer> {
    public FlightRepository flightRepository;

    @Override
    protected JpaRepository<Flight, Integer> getRepository() {
        return flightRepository;
    }
}
