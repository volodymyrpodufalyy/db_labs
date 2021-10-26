package com.podufalyy.service;

import com.podufalyy.dao.AirlineDAO;
import com.podufalyy.entities.Airline;

import java.sql.SQLException;
import java.util.List;

public class AirlineService implements ServiceInterface<Airline> {
    private final AirlineDAO dao = new AirlineDAO();

    @Override
    public List<Airline> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public Airline findByName(String name) throws SQLException {
        return dao.findByName(name);
    }

    @Override
    public void create(Airline entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(String name, Airline entity) throws SQLException {
        dao.update(name, entity);
    }

    @Override
    public void delete(String name) throws SQLException {
        dao.delete(name);
    }
}
