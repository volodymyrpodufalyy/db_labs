package com.podufalyy.service;

import com.podufalyy.domain.Airline;
import com.podufalyy.domain.Airport;
import com.podufalyy.repository.AirportRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AirportService extends AbstractService<Airport, Integer> {
    public AirportRepository airportRepository;

    @Override
    protected JpaRepository<Airport, Integer> getRepository() {
        return airportRepository;
    }

    public Airport updateEntity(Integer id, Airport object) {
        if (getRepository().findById(id).isPresent()) {
            Airport entity = airportRepository.findById(id).get();
            entity.setName(object.getName());
            return getRepository().save(entity);
        } else {
            return null;
        }
    }
}
