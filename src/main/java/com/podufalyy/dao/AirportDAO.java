package com.podufalyy.dao;

import com.podufalyy.db.DBConnection;
import com.podufalyy.entities.Airport;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AirportDAO implements DAOInterface<Airport> {
    private static final String GET_ALL = "SELECT * FROM podufalyy.airport";
    private static final String GET_BY_NAME = "SELECT * FROM podufalyy.airport WHERE name=?";
    private static final String CREATE = "INSERT podufalyy.airport "
            + "(`name`, `country_id`) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE podufalyy.airport"
            + " SET country_id=? WHERE name=?";
    private static final String DELETE = "DELETE FROM podufalyy.airport WHERE name=?";


    @Override
    public List<Airport> findAll() throws SQLException {
        List<Airport> airports = new ArrayList<>();
        try (PreparedStatement statement = DBConnection.getConnection().prepareStatement(GET_ALL)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Airport airport = new Airport(
                        resultSet.getString("name"),
                        resultSet.getInt("country_id"),
                        resultSet.getInt("city_id")
                );
                airports.add(airport);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return airports;
    }

    @Override
    public void create(Airport airline) throws SQLException {
        try (PreparedStatement statement = DBConnection.getConnection().prepareStatement(CREATE)) {
            statement.setString(1, String.valueOf(airline.getName()));
            statement.setString(2, String.valueOf(airline.getCountryId()));
            statement.setString(3, String.valueOf(airline.getCityId()));
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Airport findByName(String name) throws SQLException {
        Airport airport = null;
        try (PreparedStatement statement = DBConnection.getConnection().prepareStatement(GET_BY_NAME)) {
            statement.setString(1, name);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                airport = new Airport(
                        resultSet.getString("name"),
                        resultSet.getInt("country_id"),
                        resultSet.getInt("city_id")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return airport;
    }

    @Override
    public void update(String name, Airport airline) throws SQLException {
        try (PreparedStatement statement = DBConnection.getConnection().prepareStatement(UPDATE)) {
            statement.setString(1, airline.getName());
            statement.setInt(2, airline.getCountryId());
            statement.setInt(3, airline.getCityId());
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String name) throws SQLException {
        try (PreparedStatement statement = DBConnection.getConnection().prepareStatement(DELETE)) {
            statement.setString(1, name);
            System.out.println(statement);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
