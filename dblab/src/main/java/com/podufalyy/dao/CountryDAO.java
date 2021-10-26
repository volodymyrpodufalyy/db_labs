package com.podufalyy.dao;

import com.podufalyy.db.DBConnection;
import com.podufalyy.entities.Country;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CountryDAO implements DAOInterface<Country> {
    private static final String GET_ALL = "SELECT * FROM podufalyy.country";
    private static final String GET_BY_NAME = "SELECT * FROM podufalyy.country WHERE name=?";
    private static final String CREATE = "INSERT podufalyy.country "
            + "(`name`, `covid_rules`) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE podufalyy.country"
            + " SET covid_rules=? WHERE name=?";
    private static final String DELETE = "DELETE FROM podufalyy.country WHERE name=?";

    @Override
    public List<Country> findAll() throws SQLException {
        List<Country> countries = new ArrayList<>();
        try (PreparedStatement statement = DBConnection.getConnection().prepareStatement(GET_ALL)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Country country = new Country(
                        resultSet.getString("name"),
                        resultSet.getString("covid_rules")
                );
                countries.add(country);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return countries;
    }

    @Override
    public void create(Country country) throws SQLException {
        try (PreparedStatement statement = DBConnection.getConnection().prepareStatement(CREATE)) {
            statement.setString(1, String.valueOf(country.getName()));
            statement.setString(2, String.valueOf(country.getCovidRules()));
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Country findByName(String name) throws SQLException {
        Country country = null;
        try (PreparedStatement statement = DBConnection.getConnection().prepareStatement(GET_BY_NAME)) {
            statement.setString(1, name);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                country = new Country(
                        resultSet.getString("name"),
                        resultSet.getString("covid_rules")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return country;
    }

    @Override
    public void update(String name, Country country) throws SQLException {
        try (PreparedStatement statement = DBConnection.getConnection().prepareStatement(UPDATE)) {
            statement.setString(1, country.getName());
            statement.setString(2, country.getCovidRules());
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
