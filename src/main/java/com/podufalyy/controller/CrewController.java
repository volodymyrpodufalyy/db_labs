package com.podufalyy.controller;

import com.podufalyy.entities.Crew;
import com.podufalyy.service.CrewService;

import java.sql.SQLException;
import java.util.List;

public class CrewController implements ControllerInterface<Crew> {
    CrewService service = new CrewService();

    @Override
    public List<Crew> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public void create(Crew entity) throws SQLException {
        service.create(entity);
    }

    @Override
    public Crew findByName(String name) throws SQLException {
        return service.findByName(name);
    }

    @Override
    public Crew findById(Integer name) throws SQLException {
        return service.findById(name);
    }

    @Override
    public void update(String name, Crew entity) throws SQLException {
        service.update(name, entity);
    }

    @Override
    public void delete(String name) throws SQLException {
        service.delete(name);
    }
}
