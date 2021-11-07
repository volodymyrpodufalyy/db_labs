package com.podufalyy.service;

import com.podufalyy.domain.Country;
import com.podufalyy.repository.CountryRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public class CountryService extends AbstractService<Country, Integer> {
    public CountryRepository countryRepository;

    @Override
    protected JpaRepository<Country, Integer> getRepository() {
        return countryRepository;
    }
}
