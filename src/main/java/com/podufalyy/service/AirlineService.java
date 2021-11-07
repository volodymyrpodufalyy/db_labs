package com.podufalyy.service;

import com.podufalyy.domain.Airline;
import com.podufalyy.repository.AirlineRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AirlineService extends AbstractService<Airline, Integer> {
    public AirlineRepository airlineRepository;

    @Override
    protected JpaRepository<Airline, Integer> getRepository() {
        return airlineRepository;
    }
}
