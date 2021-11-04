package com.podufalyy.service;

import com.podufalyy.dao.CityDAO;
import com.podufalyy.entities.City;

import java.sql.SQLException;
import java.util.List;

public class CityService implements ServiceInterface<City> {
    private final CityDAO dao = new CityDAO();

    @Override
    public List<City> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public City findByName(String name) throws SQLException {
        return dao.findByName(name);
    }

    @Override
    public void create(City entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, City entity) throws SQLException {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer name) throws SQLException {
        dao.delete(name);
    }
}
