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

    public Airline updateEntity(Integer id, Airline object) {
        if (getRepository().findById(id).isPresent()) {
            Airline airline = airlineRepository.findById(id).get();
            airline.setName(object.getName());
            return getRepository().save(airline);
        } else {
            return null;
        }
    }
}
