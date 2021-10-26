package com.podufalyy.controller;

import com.podufalyy.entities.Country;
import com.podufalyy.service.CountryService;

import java.sql.SQLException;
import java.util.List;

public class CountryController implements ControllerInterface<Country> {
    CountryService service = new CountryService();

    @Override
    public List<Country> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public void create(Country entity) throws SQLException {
        service.create(entity);
    }

    @Override
    public Country findByName(String name) throws SQLException {
        return service.findByName(name);
    }

    @Override
    public void update(String name, Country entity) throws SQLException {
        service.update(name, entity);
    }

    @Override
    public void delete(String name) throws SQLException {
        service.delete(name);
    }
}
