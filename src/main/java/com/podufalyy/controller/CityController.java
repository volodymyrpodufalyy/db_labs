package com.podufalyy.controller;

import com.podufalyy.entities.City;
import com.podufalyy.service.CityService;

import java.sql.SQLException;
import java.util.List;

public class CityController implements ControllerInterface<City> {
    CityService service = new CityService();

    @Override
    public List<City> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public void create(City entity) throws SQLException {
        service.create(entity);
    }

    @Override
    public City findByName(String name) throws SQLException {
        return service.findByName(name);
    }

    @Override
    public void update(Integer id, City entity) throws SQLException {
        service.update(id, entity);
    }

    @Override
    public void delete(Integer name) throws SQLException {
        service.delete(name);
    }
}
