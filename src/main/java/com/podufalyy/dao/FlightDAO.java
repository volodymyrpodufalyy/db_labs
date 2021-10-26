package com.podufalyy.dao;

import com.podufalyy.db.DBConnection;
import com.podufalyy.entities.Flight;
import com.podufalyy.entities.Plane;
import com.podufalyy.enums.PlaneType;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FlightDAO implements DAOInterface<Flight> {
    private static final String GET_ALL = "SELECT * FROM podufalyy.flight";
    private static final String GET_BY_ID = "SELECT * FROM podufalyy.flight WHERE id=?";
    private static final String CREATE = "INSERT podufalyy.flight "
            + "(`departure_time`, `arrival_time`, " +
            "`allowed_luggage_kg`, `connected_flight`, " +
            "`airline_id`, `airport_id`, `airport_country_id`," +
            " `airport_id1`, `airport_country_id1`," +
            " `plane_id`, `class_id`) VALUES (?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE podufalyy.flight"
            + " SET departure_time=? WHERE id=?";
    private static final String DELETE = "DELETE FROM podufalyy.flight WHERE id=?";


    @Override
    public List<Flight> findAll() throws SQLException {
        List<Flight> flights = new ArrayList<>();
        try (PreparedStatement statement = DBConnection.getConnection().prepareStatement(GET_ALL)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Flight flight = new Flight(
                        resultSet.getTimestamp("departure_time"),
                        resultSet.getTimestamp("arrival_time"),
                        resultSet.getFloat("allowed_luggage_kg"),
                        resultSet.getInt("connected_flight"),
                        resultSet.getInt("airline_id"),
                        resultSet.getInt("airport_id"),
                        resultSet.getInt("airport_country_id"),
                        resultSet.getInt("airport_id1"),
                        resultSet.getInt("airport_country_id1"),
                        resultSet.getInt("plane_id"),
                        resultSet.getInt("class_id")
                );
                flights.add(flight);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flights;
    }

    @Override
    public void create(Flight flight) throws SQLException {
        try (PreparedStatement statement = DBConnection.getConnection().prepareStatement(CREATE)) {
            statement.setTimestamp(1, flight.getDepartureTime());
            statement.setTimestamp(2, flight.getArrivalTime());
            statement.setFloat(3, flight.getAllowedLuggage());
            statement.setInt(4, flight.getConnectedFlight());
            statement.setInt(5, flight.getAirlineId());
            statement.setInt(6, flight.getDepartureAirportId());
            statement.setInt(7, flight.getDepartureAirportCountryId());
            statement.setInt(8, flight.getArrivalAirportId());
            statement.setInt(9, flight.getArrivalAirportCountryId());
            statement.setInt(10, flight.getPlaneId());
            statement.setInt(11, flight.getFlightClassId());
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Flight findByName(String id) throws SQLException {
        Flight flight = null;
        try (PreparedStatement statement = DBConnection.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setString(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                flight = new Flight(
                        resultSet.getTimestamp("departure_time"),
                        resultSet.getTimestamp("arrival_time"),
                        resultSet.getFloat("allowed_luggage_kg"),
                        resultSet.getInt("connected_flight"),
                        resultSet.getInt("airline_id"),
                        resultSet.getInt("airport_id"),
                        resultSet.getInt("airport_country_id"),
                        resultSet.getInt("airport_id1"),
                        resultSet.getInt("airport_country_id1"),
                        resultSet.getInt("plane_id"),
                        resultSet.getInt("class_id")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flight;
    }

    @Override
    public void update(String name, Flight flight) throws SQLException {
        try (PreparedStatement statement = DBConnection.getConnection().prepareStatement(UPDATE)) {
            statement.setTimestamp(1, flight.getDepartureTime());
            statement.setTimestamp(2, flight.getArrivalTime());
            statement.setFloat(3, flight.getAllowedLuggage());
            statement.setInt(4, flight.getConnectedFlight());
            statement.setInt(5, flight.getAirlineId());
            statement.setInt(6, flight.getDepartureAirportId());
            statement.setInt(7, flight.getDepartureAirportCountryId());
            statement.setInt(8, flight.getArrivalAirportId());
            statement.setInt(9, flight.getArrivalAirportCountryId());
            statement.setInt(10, flight.getPlaneId());
            statement.setInt(11, flight.getFlightClassId());
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
