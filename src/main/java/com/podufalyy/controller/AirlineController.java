package com.podufalyy.controller;

import com.podufalyy.entities.Airline;
import com.podufalyy.service.AirlineService;

import java.sql.SQLException;
import java.util.List;

public class AirlineController implements ControllerInterface<Airline> {
    AirlineService service = new AirlineService();

    @Override
    public List<Airline> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public void create(Airline entity) throws SQLException {
        service.create(entity);
    }

    @Override
    public Airline findByName(String name) throws SQLException {
        return service.findByName(name);
    }

    @Override
    public void update(String name, Airline entity) throws SQLException {
        service.update(name, entity);
    }

    @Override
    public void delete(String name) throws SQLException {
        service.delete(name);
    }
}
