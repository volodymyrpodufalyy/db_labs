package com.podufalyy.controller;

import com.podufalyy.entities.Plane;
import com.podufalyy.service.PlaneService;

import java.sql.SQLException;
import java.util.List;

public class PlaneController implements ControllerInterface<Plane> {
    PlaneService service = new PlaneService();

    @Override
    public List<Plane> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public void create(Plane entity) throws SQLException {
        service.create(entity);
    }

    @Override
    public Plane findByName(String name) throws SQLException {
        return service.findByName(name);
    }

    @Override
    public void update(String name, Plane entity) throws SQLException {
        service.update(name, entity);
    }

    @Override
    public void delete(String name) throws SQLException {
        service.delete(name);
    }
}
