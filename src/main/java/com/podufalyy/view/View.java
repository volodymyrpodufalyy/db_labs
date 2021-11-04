package com.podufalyy.view;

import com.podufalyy.controller.*;
import com.podufalyy.entities.*;
import com.podufalyy.enums.ClassType;
import com.podufalyy.enums.PlaneType;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class View {
    private static final Scanner SCANNER = new Scanner(System.in);
    private final Map<String, PrintInterface> menu = new LinkedHashMap<>();

    private final AirlineController airlineController = new AirlineController();
    private final CountryController countryController = new CountryController();
    private final AirportController airportController = new AirportController();
    private final CityController cityController = new CityController();
    private final FlightController flightController = new FlightController();
    private final FlightClassController flightClassController = new FlightClassController();
    private final UserController userController = new UserController();
    private final CrewController crewController = new CrewController();
    private final UserHasFlightController userHasFlightController = new UserHasFlightController();
    private final PlaneController planeController = new PlaneController();


    public View() {
        menu.put("11", this::getAllAirlines);
        menu.put("12", this::getAirlineByName);
        menu.put("13", this::createAirline);
        menu.put("14", this::updateAirline);
        menu.put("15", this::deleteAirline);

        menu.put("21", this::getAllCountries);
        menu.put("22", this::getCountryByName);
        menu.put("23", this::createCountry);
        menu.put("24", this::updateCountry);
        menu.put("25", this::deleteCountry);

        menu.put("31", this::getAllPlanes);
        menu.put("32", this::getPlaneByName);
        menu.put("33", this::createPlane);
        menu.put("34", this::updatePlane);
        menu.put("35", this::deletePlane);

        menu.put("41", this::getAllCities);
        menu.put("42", this::getCityByName);
        menu.put("43", this::createCity);
        menu.put("44", this::updateCity);
        menu.put("45", this::deleteCity);

        menu.put("51", this::getAllAirports);
        menu.put("52", this::getAirportByName);
        menu.put("53", this::createAirport);
        menu.put("54", this::updateAirport);
        menu.put("55", this::deleteAirport);

        menu.put("61", this::getAllFlights);
        menu.put("62", this::getFlightById);
        menu.put("63", this::createFlight);
        menu.put("64", this::updateFlight);
        menu.put("65", this::deleteFlight);

        menu.put("71", this::getAllUsers);
        menu.put("72", this::getUserById);
        menu.put("73", this::createUser);
        menu.put("74", this::updateUser);
        menu.put("75", this::deleteUser);

        menu.put("81", this::getAllFlightClasses);
        menu.put("82", this::getFlightClassById);
        menu.put("83", this::createFlightClass);
        menu.put("84", this::updateFlightClass);
        menu.put("85", this::deleteFlightClass);

        menu.put("91", this::getAllCrews);
        menu.put("92", this::getCrewById);
        menu.put("93", this::createCrew);
        menu.put("94", this::updateCrew);
        menu.put("95", this::deleteCrew);

        menu.put("101", this::getAllUserFlights);
        menu.put("102", this::getUserHasFlightById);
        menu.put("103", this::createUserHasFlight);
        menu.put("104", this::updateUserHasFlight);
        menu.put("105", this::deleteUserHasFlight);
    }

    public final void show() {
        String input;
        Table table = new Table();
        table.showTable();
        System.out.println("\nEnter numbers:\n");
        do {
            try {
                input = SCANNER.next();
                menu.get(input).print();
            } catch (Exception ignored) {
            }
        } while (SCANNER.hasNext());
    }

    private void getAllAirlines() throws SQLException {
        System.out.println("\n");
        System.out.println(airlineController.findAll() + "\n");
    }

    private void getAirlineByName() throws SQLException {
        System.out.println("\nEnter id: ");
        Integer name = SCANNER.nextInt();
        System.out.println(airlineController.findById(name) + "\n");
    }

    private Airline getAirlineInputs() {
        System.out.println("\nEnter name: ");
        String name = SCANNER.next();
        System.out.println("Enter countryId: ");
        Integer countryId = SCANNER.nextInt();
        return new Airline(name, countryId);
    }

    private void createAirline() throws SQLException {
        System.out.println("\n");
        Airline airline = getAirlineInputs();
        airlineController.create(airline);
        System.out.println("Airline was successfully created!\n");
    }

    private void updateAirline() throws SQLException {
        System.out.println("\nEnter ID for updating: ");
        Integer id = SCANNER.nextInt();
        Airline airline = getAirlineInputs();
        airline.setId(id);
        airlineController.update(airline.getId(), airline);
        System.out.println("Updated airline with id = " + id + "\n");
    }

    private void deleteAirline() throws SQLException {
        System.out.println("\nEnter ID to delete airline: ");
        int id = SCANNER.nextInt();
        airlineController.delete(id);
        System.out.println("Deleted airline with ID = " + id + "\n");
    }


    private void getAllCountries() throws SQLException {
        System.out.println("\n");
        System.out.println(countryController.findAll() + "\n");
    }

    private void getCountryByName() throws SQLException {
        System.out.println("\nEnter Name: ");
        String name = SCANNER.next();
        System.out.println(countryController.findByName(name) + "\n");
    }

    private Country getCountryInputs() {
        System.out.println("\nEnter name: ");
        String name = SCANNER.next();
        System.out.println("Enter covid rules: ");
        String covidRules = SCANNER.next();
        return new Country(name, covidRules);
    }

    private void createCountry() throws SQLException {
        System.out.println("\n");
        Country country = getCountryInputs();
        countryController.create(country);
        System.out.println("Country was successfully created!\n");
    }

    private void updateCountry() throws SQLException {
        System.out.println("\nEnter id for updating: ");
        Integer id = SCANNER.nextInt();
        Country country = getCountryInputs();
        country.setId(id);
        System.out.println(country.getName());
        countryController.update(country.getId(), country);
        System.out.println("Updated country with id = " + id + "\n");
    }

    private void deleteCountry() throws SQLException {
        System.out.println("\nEnter id to delete country: ");
        Integer id = SCANNER.nextInt();
        countryController.delete(id);
        System.out.println("Deleted country with id = " + id + "\n");
    }


    private void getAllPlanes() throws SQLException {
        System.out.println("\n");
        System.out.println(planeController.findAll() + "\n");
    }

    private void getPlaneByName() throws SQLException {
        System.out.println("\nEnter id: ");
        Integer id = SCANNER.nextInt();
        System.out.println(planeController.findById(id) + "\n");
    }

    private Plane getPlaneInputs() {
        System.out.println("\nEnter name: ");
        String name = SCANNER.next();
        System.out.println("Enter seats: ");
        Integer seats = SCANNER.nextInt();
        System.out.println("Enter type: ");
        PlaneType type = PlaneType.valueOf(SCANNER.next());
        System.out.println("Enter airlineId: ");
        Integer airlineId = SCANNER.nextInt();
        return new Plane(name, seats, type, airlineId);
    }

    private void createPlane() throws SQLException {
        System.out.println("\n");
        Plane plane = getPlaneInputs();
        planeController.create(plane);
        System.out.println("Plane was successfully created!\n");
    }

    private void updatePlane() throws SQLException {
        System.out.println("\nEnter id for updating: ");
        Integer id = SCANNER.nextInt();
        Plane plane = getPlaneInputs();
        plane.setId(id);
        planeController.update(plane.getId(), plane);
        System.out.println("Updated plane with id = " + id + "\n");
    }

    private void deletePlane() throws SQLException {
        System.out.println("\nEnter id to delete plane: ");
        Integer id = SCANNER.nextInt();
        planeController.delete(id);
        System.out.println("Deleted plane with id = " + id + "\n");
    }


    private void getAllCities() throws SQLException {
        System.out.println("\n");
        System.out.println(cityController.findAll() + "\n");
    }

    private void getCityByName() throws SQLException {
        System.out.println("\nEnter Name: ");
        String name = SCANNER.next();
        System.out.println(cityController.findByName(name) + "\n");
    }

    private City getCityInputs() {
        System.out.println("\nEnter name: ");
        String name = SCANNER.next();
        System.out.println("Enter country id: ");
        Integer countryId = SCANNER.nextInt();
        return new City(name, countryId);
    }

    private void createCity() throws SQLException {
        System.out.println("\n");
        City city = getCityInputs();
        cityController.create(city);
        System.out.println("City was successfully created!\n");
    }

    private void updateCity() throws SQLException {
        System.out.println("\nEnter id for updating: ");
        Integer id = SCANNER.nextInt();
        City city = getCityInputs();
        city.setId(id);
        cityController.update(city.getId(), city);
        System.out.println("Updated city with id = " + id + "\n");
    }

    private void deleteCity() throws SQLException {
        System.out.println("\nEnter id to delete city: ");
        Integer id = SCANNER.nextInt();
        cityController.delete(id);
        System.out.println("Deleted city with id = " + id + "\n");
    }


    private void getAllAirports() throws SQLException {
        System.out.println("\n");
        System.out.println(airportController.findAll() + "\n");
    }

    private void getAirportByName() throws SQLException {
        System.out.println("\nEnter id: ");
        Integer id = SCANNER.nextInt();
        System.out.println(airportController.findById(id) + "\n");
    }

    private Airport getAirportInputs() {
        System.out.println("\nEnter name: ");
        String name = SCANNER.next();
        System.out.println("Enter country id: ");
        Integer countryId = SCANNER.nextInt();
        System.out.println("Enter city id: ");
        Integer cityId = SCANNER.nextInt();
        return new Airport(name, countryId, cityId);
    }

    private void createAirport() throws SQLException {
        System.out.println("\n");
        Airport airport = getAirportInputs();
        airportController.create(airport);
        System.out.println("Airport was successfully created!\n");
    }

    private void updateAirport() throws SQLException {
        System.out.println("\nEnter ID for updating: ");
        Integer id = SCANNER.nextInt();
        Airport airport = getAirportInputs();
        airport.setId(id);
        airportController.update(airport.getId(), airport);
        System.out.println("Updated airport with id = " + id + "\n");
    }

    private void deleteAirport() throws SQLException {
        System.out.println("\nEnter ID to delete airport: ");
        Integer id = SCANNER.nextInt();
        airportController.delete(id);
        System.out.println("Deleted airport with id = " + id + "\n");
    }


    private void getAllFlights() throws SQLException {
        System.out.println("\n");
        System.out.println(flightController.findAll() + "\n");
    }

    private void getFlightById() throws SQLException {
        System.out.println("\nEnter ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(flightController.findById(id) + "\n");
    }

    private Flight getFlightInputs() {
        System.out.println("\nEnter departure time: ");
        Timestamp departureTime = Timestamp.valueOf(SCANNER.next());
        System.out.println("Enter arrival time: ");
        Timestamp arrivalTime = Timestamp.valueOf(SCANNER.next());
        System.out.println("Enter allowedLuggage: ");
        Float allowedLuggage = SCANNER.nextFloat();
        System.out.println("Enter connected flight: ");
        Integer connectedFlight = SCANNER.nextInt();
        System.out.println("Enter allowedLuggage: ");
        Integer airlineId = SCANNER.nextInt();
        System.out.println("Enter departure airport id: ");
        Integer departureAirportId = SCANNER.nextInt();
        System.out.println("Enter arrival airport id: ");
        Integer arrivalAirportId = SCANNER.nextInt();
        System.out.println("Enter departure airport  country id: ");
        Integer departureCountryAirportId = SCANNER.nextInt();
        System.out.println("Enter arrival airport country id: ");
        Integer arrivalCountryAirportId = SCANNER.nextInt();
        System.out.println("Enter plane id: ");
        Integer planeId = SCANNER.nextInt();
        System.out.println("Enter arrival flight class id: ");
        Integer flightClassId = SCANNER.nextInt();
        return new Flight(departureTime, arrivalTime, allowedLuggage, connectedFlight,
                airlineId, departureAirportId, arrivalAirportId, departureCountryAirportId,
                arrivalCountryAirportId, planeId, flightClassId);
    }

    private void createFlight() throws SQLException {
        System.out.println("\n");
        Flight flight = getFlightInputs();
        flightController.create(flight);
        System.out.println("Flight was successfully created!\n");
    }

    private void updateFlight() throws SQLException {
        System.out.println("\nEnter ID for updating: ");
        Timestamp id = Timestamp.valueOf(SCANNER.next());
        Flight flight = getFlightInputs();
        flight.setDepartureTime(id);
        flightController.update(flight.getDepartureAirportId(), flight);
        System.out.println("Updated flight with ID = " + id + "\n");
    }

    private void deleteFlight() throws SQLException {
        System.out.println("\nEnter ID to delete flight: ");
        int id = SCANNER.nextInt();
        flightController.delete(id);
        System.out.println("Deleted flight with ID = " + id + "\n");
    }


    private void getAllUsers() throws SQLException {
        System.out.println("\n");
        System.out.println(userController.findAll() + "\n");
    }

    private void getUserById() throws SQLException {
        System.out.println("\nEnter ID: ");
        String id = SCANNER.next();
        System.out.println(userController.findByName(id) + "\n");
    }

    private User getUserInputs() {
        System.out.println("\nEnter surname: ");
        String name = SCANNER.next();
        System.out.println("Enter name: ");
        String lastname = SCANNER.next();
        System.out.println("Enter email: ");
        String email = SCANNER.next();
        System.out.println("Enter gender: ");
        String password = SCANNER.next();
        System.out.println("Enter birthday: ");
        String passportId = SCANNER.next();
        return new User(name, lastname, email, password, passportId);
    }

    private void createUser() throws SQLException {
        System.out.println("\n");
        User user = getUserInputs();
        userController.create(user);
        System.out.println("User was successfully created!\n");
    }

    private void updateUser() throws SQLException {
        System.out.println("\nEnter ID for updating: ");
        String id = SCANNER.next();
        User user = getUserInputs();
        user.setLastName(id);
        userController.update(user.getLastName(), user);
        System.out.println("Updated user with ID = " + id + "\n");
    }

    private void deleteUser() throws SQLException {
        System.out.println("\nEnter ID to delete user: ");
        int id = SCANNER.nextInt();
        userController.delete(id);
        System.out.println("Deleted user with ID = " + id + "\n");
    }


    private void getAllFlightClasses() throws SQLException {
        System.out.println("\n");
        System.out.println(flightClassController.findAll() + "\n");
    }

    private void getFlightClassById() throws SQLException {
        System.out.println("\nEnter ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(flightClassController.findById(id) + "\n");
    }

    private FlightCLass getFlightClassInputs() {
        System.out.println("\nEnter type: ");
        ClassType type = ClassType.valueOf(SCANNER.next());
        System.out.println("Enter benefits: ");
        String benefits = SCANNER.next();
        System.out.println("Enter price: ");
        Float price = SCANNER.nextFloat();
        return new FlightCLass(type, benefits, price);
    }

    private void createFlightClass() throws SQLException {
        System.out.println("\n");
        FlightCLass review = getFlightClassInputs();
        flightClassController.create(review);
        System.out.println("Class was successfully created!\n");
    }

    private void updateFlightClass() throws SQLException {
        System.out.println("\nEnter ID for updating: ");
        String value = SCANNER.next();
        FlightCLass flightClass = getFlightClassInputs();
        flightClass.setBenefits(value);
        flightClassController.update(flightClass.getBenefits(), flightClass);
        System.out.println("Updated class with ID = " + value + "\n");
    }

    private void deleteFlightClass() throws SQLException {
        System.out.println("\nEnter ID to delete review: ");
        int id = SCANNER.nextInt();
        flightClassController.delete(id);
        System.out.println("Deleted review with ID = " + id + "\n");
    }


    private void getAllCrews() throws SQLException {
        System.out.println("\n");
        System.out.println(crewController.findAll() + "\n");
    }

    private void getCrewById() throws SQLException {
        System.out.println("\nEnter ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(crewController.findById(id) + "\n");
    }

    private Crew getCrewInputs() {
        System.out.println("\nEnter m pilot: ");
        String mainPilot = SCANNER.next();
        System.out.println("Enter stewardess: ");
        String stewardess = SCANNER.next();
        System.out.println("Enter sec pilot: ");
        String secondPilot = SCANNER.next();
        System.out.println("Enter plane id: ");
        Integer planeId = SCANNER.nextInt();
        return new Crew(mainPilot, stewardess, secondPilot, planeId);
    }

    private void createCrew() throws SQLException {
        System.out.println("\n");
        Crew crew = getCrewInputs();
        crewController.create(crew);
        System.out.println("crew was successfully created!\n");
    }

    private void updateCrew() throws SQLException {
        System.out.println("\nEnter ID for updating: ");
        String name = SCANNER.next();
        Crew crew = getCrewInputs();
        crew.setMainPilot(name);
        crewController.update(crew.getMainPilot(), crew);
        System.out.println("Updated crew with ID = " + name + "\n");
    }

    private void deleteCrew() throws SQLException {
        System.out.println("\nEnter ID to delete amenity: ");
        int id = SCANNER.nextInt();
        crewController.delete(id);
        System.out.println("Deleted crew with ID = " + id + "\n");
    }


    private void getAllUserFlights() throws SQLException {
        System.out.println("\n");
        System.out.println(userHasFlightController.findAll() + "\n");
    }

    private void getUserHasFlightById() throws SQLException {
        System.out.println("\nEnter ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(userHasFlightController.findById(id) + "\n");
    }

    private UserHasFlight getUserHasFlightInputs() {
        System.out.println("\nEnter user id: ");
        Integer userId = SCANNER.nextInt();
        System.out.println("Enter flight id: ");
        Integer flightId = SCANNER.nextInt();
        System.out.println("Enter flightArrivalAirportId time: ");
        Integer flightArrivalAirportId = SCANNER.nextInt();
        System.out.println("Enter flightArrivalAirportCountryId time: ");
        Integer flightArrivalAirportCountryId = SCANNER.nextInt();
        System.out.println("Enter flightDepartureAirportId time: ");
        Integer flightDepartureAirportId = SCANNER.nextInt();
        System.out.println("Enter flightDepartureAirportCountryId amount: ");
        Integer flightDepartureAirportCountryId = SCANNER.nextInt();
        System.out.println("Enter flightPlaneId: ");
        Integer flightPlaneId = SCANNER.nextInt();
        return new UserHasFlight(userId, flightId,
                flightArrivalAirportId, flightArrivalAirportCountryId,
                flightDepartureAirportId, flightDepartureAirportCountryId, flightPlaneId);
    }

    private void createUserHasFlight() throws SQLException {
        System.out.println("\n");
        UserHasFlight reservation = getUserHasFlightInputs();
        userHasFlightController.create(reservation);
        System.out.println("User flight was successfully created!\n");
    }

    private void updateUserHasFlight() throws SQLException {
        System.out.println("\nEnter ID for updating: ");
        Integer id = SCANNER.nextInt();
        UserHasFlight userFlight = getUserHasFlightInputs();
        userFlight.setFlightId(id);
        userHasFlightController.update(userFlight.getFlightId(), userFlight);
        System.out.println("Updated user flight with ID = " + id + "\n");
    }

    private void deleteUserHasFlight() throws SQLException {
        System.out.println("\nEnter ID to delete reservation: ");
        int id = SCANNER.nextInt();
        userHasFlightController.delete(id);
        System.out.println("Deleted user flight with ID = " + id + "\n");
    }
}
