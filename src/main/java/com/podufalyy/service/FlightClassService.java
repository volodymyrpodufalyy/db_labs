package com.podufalyy.service;

import com.podufalyy.domain.FlightCLass;
import com.podufalyy.repository.FlightClassRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class FlightClassService extends AbstractService<FlightCLass, Integer> {
    public FlightClassRepository flightClassRepository;

    @Override
    protected JpaRepository<FlightCLass, Integer> getRepository() {
        return flightClassRepository;
    }
}
