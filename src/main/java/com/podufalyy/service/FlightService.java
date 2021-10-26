package com.podufalyy.service;

import com.podufalyy.dao.FlightClassDAO;
import com.podufalyy.dao.FlightDAO;
import com.podufalyy.entities.Flight;
import com.podufalyy.entities.FlightCLass;

import java.sql.SQLException;
import java.util.List;

public class FlightService implements ServiceInterface<Flight> {
    private final FlightDAO dao = new FlightDAO();

    @Override
    public List<Flight> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public Flight findByName(String name) throws SQLException {
        return dao.findByName(name);
    }

    @Override
    public void create(Flight entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(String name, Flight entity) throws SQLException {
        dao.update(name, entity);
    }

    @Override
    public void delete(String name) throws SQLException {
        dao.delete(name);
    }
}
