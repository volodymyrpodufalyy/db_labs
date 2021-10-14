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
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `covid_rules` VARCHAR(450) NULL,
  PRIMARY KEY (`id`));

INSERT INTO country (id, name, covid_rules) VALUES
(1, 'Ukraine', 'PLR test and app'),
(2, 'USA', 'Vaccination sertificate'),
(3, 'Poland', 'PLR test and vaccination'),
(4, 'UK', 'Vaccination sertificate'),
(5, 'Spain', 'Vaccination sertificate'),
(6, 'Italy', 'Vaccination sertificate and PLR test'),
(7, 'Germany', 'Vaccination sertificate'),
(8, 'Belgium', 'Vaccination sertificate'),
(9, 'Canada', 'PLR test'),
(10, 'Egypt', 'PLR test');


CREATE TABLE airline (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `country_id` INT NOT NULL,
  PRIMARY KEY (`id`, `country_id`),
  INDEX `fk_airline_country1_idx` (`country_id` ASC) VISIBLE,
  CONSTRAINT `fk_airline_country1`
    FOREIGN KEY (`country_id`)
    REFERENCES `Podufalyy`.`country` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

INSERT INTO airline (id, name, country_id) VALUES
(1, 'Ukraine airlines', '1'),
(2, 'USA airlines', '2'),
(3, 'Poland airlines', '3'),
(4, 'UK airlines', '4'),
(5, 'Spain airlines', '5'),
(6, 'Italy airlines', '6'),
(7, 'Germany airlines', '7'),
(8, 'Belgium airlines', '8'),
(9, 'Canada airlines', '9'),
(10, 'Egypt airlines', '10');


CREATE TABLE city (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `country_id` INT NOT NULL,
  PRIMARY KEY (`id`, `country_id`),
  INDEX `fk_city_country1_idx` (`country_id` ASC) VISIBLE,
  CONSTRAINT `fk_city_country1`
    FOREIGN KEY (`country_id`)
    REFERENCES `Podufalyy`.`country` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

INSERT INTO city (id, name, country_id) VALUES
(1, 'Kyiv', '1'),
(2, 'New York', '2'),
(3, 'Warsaw', '3'),
(4, 'London', '4'),
(5, 'Madrid', '5'),
(6, 'Rome', '6'),
(7, 'Berlin', '7'),
(8, 'Brussels', '8'),
(9, 'Toronto', '9'),
(10, 'Kair', '10');


CREATE TABLE airport (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `country_id` INT NOT NULL,
  `city_id` INT NOT NULL,
  PRIMARY KEY (`id`, `country_id`, `city_id`),
  INDEX `fk_airport_city1_idx` (`city_id` ASC) VISIBLE,
  CONSTRAINT `fk_airport_city1`
    FOREIGN KEY (`city_id`)
    REFERENCES `Podufalyy`.`city` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

INSERT INTO airport (id, name,country_id, city_id) VALUES
(1, 'Boryspil airport', '1', '1'),
(2, 'John F. Kennedy International Airport', '2', '2'),
(3, 'Warsaw Chopin Airport', '3', '3'),
(4, 'Haethrow airport', '4', '4'),
(5, 'Madrid-Barajas Adolfo Suárez Airport', '5', '5'),
(6, 'AEROPORTI DI ROMA', '6', '6'),
(7, 'Berlin-Tegel airport', '7', '7'),
(8, 'Brussels Airport', '8', '8'),
(9, 'Toronto Pearson International Airport', '9', '9'),
(10, 'Cairo International Airport', '10', '10');


CREATE TABLE plane (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `seats` VARCHAR(45) NOT NULL,
  `type` ENUM('standart', 'military', 'freight') NULL,
  `airline_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_plane_airline1_idx` (`airline_id` ASC) VISIBLE,
  CONSTRAINT `fk_plane_airline1`
    FOREIGN KEY (`airline_id`)
    REFERENCES `Podufalyy`.`airline` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

INSERT INTO plane (id, name, seats, type, airline_id) VALUES
(1, 'Boeing 777', '100', 'standart', '1'),
(2, 'Boeing 772', '100', 'military', '2'),
(3, 'Boeing 737', '100', 'freight', '3'),
(4, 'Airbus A320', '100', 'military', '4'),
(5, 'Airbus A330', '100', 'freight', '5'),
(6, 'Boeing 787', '100', 'standart', '6'),
(7, 'BOEING 767-300ER', '100', 'standart', '7'),
(8, 'BOEING 737-800', '100', 'freight', '8'),
(9, 'EMBRAER-190', '100', 'standart', '9'),
(10, 'EMBRAER-195', '100', 'military', '10');


CREATE TABLE flight (
  `id` INT NOT NULL AUTO_INCREMENT,
  `departure_time` TIMESTAMP(2) NOT NULL,
  `arrival_time` TIMESTAMP(2) NULL,
  `allowed_luggage_kg` FLOAT NULL,
  `connected_flight` INT NULL,
  `airline_id` INT NOT NULL,
  `airport_id` INT NOT NULL,
  `airport_country_id` INT NOT NULL,
  `airport_id1` INT NOT NULL,
  `airport_country_id1` INT NOT NULL,
  `plane_id` INT NOT NULL,
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
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `lastname` VARCHAR(45) NOT NULL,
  `email` VARCHAR(255) NULL,
  `password` VARCHAR(32) NOT NULL,
  `passport_id` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));


CREATE TABLE crew (
  `id` INT NOT NULL AUTO_INCREMENT,
  `main_pilot` VARCHAR(45) NOT NULL,
  `stewardess` VARCHAR(45) NOT NULL,
  `second_pilot` VARCHAR(45) NOT NULL,
  `plane_id` INT NOT NULL,
  PRIMARY KEY (`id`, `plane_id`),
  INDEX `fk_crew_plane1_idx` (`plane_id` ASC) VISIBLE,
  CONSTRAINT `fk_crew_plane1`
    FOREIGN KEY (`plane_id`)
    REFERENCES `Podufalyy`.`plane` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


CREATE TABLE class (
  `id` INT NOT NULL AUTO_INCREMENT,
  `type` ENUM('econom', 'premium', 'business') NOT NULL,
  `benefits` VARCHAR(350) NOT NULL,
  `price` FLOAT NOT NULL,
  `flight_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_class_flight1_idx` (`flight_id` ASC) VISIBLE,
  CONSTRAINT `fk_class_flight1`
    FOREIGN KEY (`flight_id`)
    REFERENCES `Podufalyy`.`flight` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


CREATE TABLE user_has_flight (
  `user_id` INT NOT NULL,
  `flight_id` INT NOT NULL,
  `flight_airport_id` INT NOT NULL,
  `flight_airport_country_id` INT NOT NULL,
  `flight_airport_id1` INT NOT NULL,
  `flight_airport_country_id1` INT NOT NULL,
  `flight_plane_id` INT NOT NULL,
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
