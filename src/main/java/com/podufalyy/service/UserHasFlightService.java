package com.podufalyy.service;

import com.podufalyy.dao.CrewDAO;
import com.podufalyy.dao.UserHasFlightDAO;
import com.podufalyy.entities.Crew;
import com.podufalyy.entities.UserHasFlight;

import java.sql.SQLException;
import java.util.List;


public class UserHasFlightService implements ServiceInterface<UserHasFlight> {
    private final UserHasFlightDAO dao = new UserHasFlightDAO();

    @Override
    public List<UserHasFlight> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public UserHasFlight findByName(String name) throws SQLException {
        return dao.findByName(name);
    }

    @Override
    public UserHasFlight findById(Integer name) throws SQLException {
        return dao.findById(name);
    }


    @Override
    public void create(UserHasFlight entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(String name, UserHasFlight entity) throws SQLException {
        dao.update(name, entity);
    }

    @Override
    public void delete(String name) throws SQLException {
        dao.delete(name);
    }
}
