package com.podufalyy.controller;

import com.podufalyy.entities.UserHasFlight;
import com.podufalyy.service.UserHasFlightService;

import java.sql.SQLException;
import java.util.List;

public class UserHasFlightController implements ControllerInterface<UserHasFlight> {
    UserHasFlightService service = new UserHasFlightService();

    @Override
    public List<UserHasFlight> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public void create(UserHasFlight entity) throws SQLException {
        service.create(entity);
    }

    @Override
    public UserHasFlight findByName(String name) throws SQLException {
        return service.findByName(name);
    }

    @Override
    public void update(String name, UserHasFlight entity) throws SQLException {
        service.update(name, entity);
    }

    @Override
    public void delete(String name) throws SQLException {
        service.delete(name);
    }
}
