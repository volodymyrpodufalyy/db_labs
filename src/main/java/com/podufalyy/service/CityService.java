package com.podufalyy.service;

import com.podufalyy.domain.City;
import com.podufalyy.repository.CityRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class CityService extends AbstractService<City,Integer> {
    public CityRepository cityRepository;

    @Override
    protected JpaRepository<City, Integer> getRepository() {
        return cityRepository;
    }
}
