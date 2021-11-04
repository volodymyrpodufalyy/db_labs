package com.podufalyy.service;

import com.podufalyy.dao.CountryDAO;
import com.podufalyy.entities.Country;

import java.sql.SQLException;
import java.util.List;

public class CountryService implements ServiceInterface<Country> {
    private final CountryDAO dao = new CountryDAO();

    @Override
    public List<Country> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public Country findByName(String name) throws SQLException {
        return dao.findByName(name);
    }

    @Override
    public void create(Country entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, Country entity) throws SQLException {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}
