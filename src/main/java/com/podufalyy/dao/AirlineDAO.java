package com.podufalyy.dao;

import com.podufalyy.db.DBConnection;
import com.podufalyy.entities.Airline;
import com.podufalyy.entities.City;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AirlineDAO implements DAOInterface<Airline> {
    private static final String GET_ALL = "SELECT * FROM podufalyy.airline";
    private static final String GET_BY_NAME = "SELECT * FROM podufalyy.airline WHERE name=?";
    private static final String CREATE = "INSERT podufalyy.airline "
            + "(`name`, `covid_rules`) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE podufalyy.airline"
            + " SET covid_rules=? WHERE name=?";
    private static final String DELETE = "DELETE FROM podufalyy.airline WHERE name=?";


    @Override
    public List<Airline> findAll() throws SQLException {
        List<Airline> airlines = new ArrayList<>();
        try (PreparedStatement statement = DBConnection.getConnection().prepareStatement(GET_ALL)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Airline airline = new Airline(
                        resultSet.getString("name"),
                        resultSet.getInt("country_id")
                );
                airlines.add(airline);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return airlines;
    }

    @Override
    public void create(Airline airline) throws SQLException {
        try (PreparedStatement statement = DBConnection.getConnection().prepareStatement(CREATE)) {
            statement.setString(1, String.valueOf(airline.getName()));
            statement.setString(2, String.valueOf(airline.getCountryId()));
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Airline findByName(String name) throws SQLException {
        Airline airline = null;
        try (PreparedStatement statement = DBConnection.getConnection().prepareStatement(GET_BY_NAME)) {
            statement.setString(1, name);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                airline = new Airline(
                        resultSet.getString("name"),
                        resultSet.getInt("country_id")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return airline;
    }

    @Override
    public void update(String name, Airline airline) throws SQLException {
        try (PreparedStatement statement = DBConnection.getConnection().prepareStatement(UPDATE)) {
            statement.setString(1, airline.getName());
            statement.setInt(2, airline.getCountryId());
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
