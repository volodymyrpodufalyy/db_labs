package com.podufalyy.service;

import com.podufalyy.domain.Country;
import com.podufalyy.repository.CountryRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CountryService extends AbstractService<Country, Integer> {
    public CountryRepository countryRepository;

    @Override
    protected JpaRepository<Country, Integer> getRepository() {
        return countryRepository;
    }
}
