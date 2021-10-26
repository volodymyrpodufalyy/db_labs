package com.podufalyy.dao;

import com.podufalyy.db.DBConnection;
import com.podufalyy.entities.Flight;
import com.podufalyy.entities.UserHasFlight;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserHasFlightDAO implements DAOInterface<UserHasFlight>{
    private static final String GET_ALL = "SELECT * FROM podufalyy.user_has_flight";
    private static final String GET_BY_ID = "SELECT * FROM podufalyy.user_has_flight WHERE id=?";
    private static final String CREATE = "INSERT podufalyy.user_has_flight "
            + "(`user_id`, `flight_id`, " +
            "`flight_airport_id`, `flight_airport_country_id`, " +
            "`flight_airport_id1`, `flight_airport_country_id1`, `flight_plane_id`) VALUES (?, ?, ?, ?,?,?, ?)";
    private static final String UPDATE = "UPDATE podufalyy.user_has_flight"
            + " SET departure_time=? WHERE id=?";
    private static final String DELETE = "DELETE FROM podufalyy.user_has_flight WHERE id=?";


    @Override
    public List<UserHasFlight> findAll() throws SQLException {
        List<UserHasFlight> flights = new ArrayList<>();
        try (PreparedStatement statement = DBConnection.getConnection().prepareStatement(GET_ALL)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                UserHasFlight userHasFlight = new UserHasFlight(
                        resultSet.getInt("user_id"),
                        resultSet.getInt("flight_id"),
                        resultSet.getInt("flight_airport_id"),
                        resultSet.getInt("flight_airport_country_id"),
                        resultSet.getInt("flight_airport_id1"),
                        resultSet.getInt("flight_airport_country_id1"),
                        resultSet.getInt("flight_plane_id")
                );
                flights.add(userHasFlight);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flights;
    }

    @Override
    public void create(UserHasFlight userHasFlight) throws SQLException {
        try (PreparedStatement statement = DBConnection.getConnection().prepareStatement(CREATE)) {
            statement.setInt(1, userHasFlight.getUserId());
            statement.setInt(2, userHasFlight.getFlightId());
            statement.setFloat(3, userHasFlight.getFlightDepartureAirportId());
            statement.setInt(4, userHasFlight.getFlightDepartureAirportCountryId());
            statement.setInt(5, userHasFlight.getFlightArrivalAirportId());
            statement.setInt(6, userHasFlight.getFlightArrivalAirportCountryId());
            statement.setInt(7, userHasFlight.getFlightPlaneId());
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public UserHasFlight findByName(String id) throws SQLException {
        UserHasFlight userHasFlight = null;
        try (PreparedStatement statement = DBConnection.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setString(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                userHasFlight = new UserHasFlight(
                        resultSet.getInt("user_id"),
                        resultSet.getInt("flight_id"),
                        resultSet.getInt("flight_airport_id"),
                        resultSet.getInt("flight_airport_country_id"),
                        resultSet.getInt("flight_airport_id1"),
                        resultSet.getInt("flight_airport_country_id1"),
                        resultSet.getInt("flight_plane_id")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userHasFlight;
    }

    @Override
    public void update(String name, UserHasFlight userHasFlight) throws SQLException {
        try (PreparedStatement statement = DBConnection.getConnection().prepareStatement(UPDATE)) {
            statement.setInt(1, userHasFlight.getUserId());
            statement.setInt(2, userHasFlight.getFlightId());
            statement.setFloat(3, userHasFlight.getFlightDepartureAirportId());
            statement.setInt(4, userHasFlight.getFlightDepartureAirportCountryId());
            statement.setInt(5, userHasFlight.getFlightArrivalAirportId());
            statement.setInt(6, userHasFlight.getFlightArrivalAirportCountryId());
            statement.setInt(7, userHasFlight.getFlightPlaneId());
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String id) throws SQLException {
        try (PreparedStatement statement = DBConnection.getConnection().prepareStatement(DELETE)) {
            statement.setString(1, id);
            System.out.println(statement);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
