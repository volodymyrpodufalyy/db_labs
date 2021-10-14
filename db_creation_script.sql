CREATE SCHEMA IF NOT EXISTS `Podufalyy`;
USE `Podufalyy` ;

DROP TABLE IF EXISTS crew;
DROP TABLE IF EXISTS user_has_flight;
DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS class;
DROP TABLE IF EXISTS flight;
DROP TABLE IF EXISTS plane;
DROP TABLE IF EXISTS airport;
DROP TABLE IF EXISTS city;
DROP TABLE IF EXISTS airline;
DROP TABLE IF EXISTS country;


CREATE TABLE country (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL,
  covid_rules VARCHAR(450) NULL,
  PRIMARY KEY (`id`));

CREATE TABLE airline (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL,
  country_id INT NOT NULL,
  PRIMARY KEY (`id`, `country_id`),
  INDEX `fk_airline_country1_idx` (`country_id` ASC) VISIBLE,
  CONSTRAINT `fk_airline_country1`
    FOREIGN KEY (`country_id`)
    REFERENCES `Podufalyy`.`country` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE city (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL,
  country_id INT NOT NULL,
  PRIMARY KEY (`id`, `country_id`),
  INDEX `fk_city_country1_idx` (`country_id` ASC) VISIBLE,
  CONSTRAINT `fk_city_country1`
    FOREIGN KEY (`country_id`)
    REFERENCES country (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE airport (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NULL,
  country_id INT NOT NULL,
  city_id INT NOT NULL,
  PRIMARY KEY (`id`, `country_id`, `city_id`),
  INDEX `fk_airport_city1_idx` (`city_id` ASC) VISIBLE,
  CONSTRAINT `fk_airport_city1`
    FOREIGN KEY (`city_id`)
    REFERENCES `Podufalyy`.`city` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


CREATE TABLE plane (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL,
  seats VARCHAR(45) NOT NULL,
  type ENUM('standart', 'military', 'freight') NULL,
  airline_id INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_plane_airline1_idx` (`airline_id` ASC) VISIBLE,
  CONSTRAINT `fk_plane_airline1`
    FOREIGN KEY (`airline_id`)
    REFERENCES `Podufalyy`.`airline` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE class (
  id INT NOT NULL AUTO_INCREMENT,
  type ENUM('econom', 'premium', 'business') NOT NULL,
  benefits VARCHAR(350) NOT NULL,
  price FLOAT NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE flight (
  id INT NOT NULL AUTO_INCREMENT,
  departure_time TIMESTAMP(2) NOT NULL,
  arrival_time TIMESTAMP(2) NULL,
  allowed_luggage_kg FLOAT NULL,
  connected_flight INT NULL,
  airline_id INT NOT NULL,
  airport_id INT NOT NULL,
  airport_country_id INT NOT NULL,
  airport_id1 INT NOT NULL,
  airport_country_id1 INT NOT NULL,
  plane_id INT NOT NULL,
  PRIMARY KEY (`id`, `airport_id`, `airport_country_id`, `airport_id1`, `airport_country_id1`, `plane_id`),
  INDEX `fk_flight_airline1_idx` (`airline_id` ASC) VISIBLE,
  INDEX `fk_flight_airport1_idx` (`airport_id` ASC, `airport_country_id` ASC) VISIBLE,
  INDEX `fk_flight_airport2_idx` (`airport_id1` ASC, `airport_country_id1` ASC) VISIBLE,
  INDEX `fk_flight_plane1_idx` (`plane_id` ASC) VISIBLE,
  CONSTRAINT `fk_flight_airline1`
    FOREIGN KEY (`airline_id`)
    REFERENCES `Podufalyy`.`airline` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_flight_airport1`
    FOREIGN KEY (`airport_id` , `airport_country_id`)
    REFERENCES `Podufalyy`.`airport` (`id` , `country_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_flight_airport2`
    FOREIGN KEY (`airport_id1` , `airport_country_id1`)
    REFERENCES `Podufalyy`.`airport` (`id` , `country_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_flight_plane1`
    FOREIGN KEY (`plane_id`)
    REFERENCES `Podufalyy`.`plane` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


CREATE TABLE user (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL,
  lastname VARCHAR(45) NOT NULL,
  email VARCHAR(255) NULL,
  password VARCHAR(32) NOT NULL,
  passport_id VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));


CREATE TABLE crew (
  id INT NOT NULL AUTO_INCREMENT,
  main_pilot VARCHAR(45) NOT NULL,
  stewardess VARCHAR(45) NOT NULL,
  second_pilot VARCHAR(45) NOT NULL,
  plane_id INT NOT NULL,
  PRIMARY KEY (`id`, `plane_id`),
  INDEX `fk_crew_plane1_idx` (`plane_id` ASC) VISIBLE,
  CONSTRAINT `fk_crew_plane1`
    FOREIGN KEY (`plane_id`)
    REFERENCES `Podufalyy`.`plane` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE user_has_flight (
  user_id INT NOT NULL,
  flight_id INT NOT NULL,
  flight_airport_id INT NOT NULL,
  flight_airport_country_id INT NOT NULL,
  flight_airport_id1 INT NOT NULL,
  flight_airport_country_id1 INT NOT NULL,
  flight_plane_id INT NOT NULL,
  PRIMARY KEY (`user_id`, `flight_id`, `flight_airport_id`, `flight_airport_country_id`, `flight_airport_id1`, `flight_airport_country_id1`, `flight_plane_id`),
  INDEX `fk_user_has_flight_flight1_idx` (`flight_id` ASC, `flight_airport_id` ASC, `flight_airport_country_id` ASC, `flight_airport_id1` ASC, `flight_airport_country_id1` ASC, `flight_plane_id` ASC) VISIBLE,
  INDEX `fk_user_has_flight_user1_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_user_has_flight_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `Podufalyy`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_has_flight_flight1`
    FOREIGN KEY (`flight_id` , `flight_airport_id` , `flight_airport_country_id` , `flight_airport_id1` , `flight_airport_country_id1` , `flight_plane_id`)
    REFERENCES `Podufalyy`.`flight` (`id` , `airport_id` , `airport_country_id` , `airport_id1` , `airport_country_id1` , `plane_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
