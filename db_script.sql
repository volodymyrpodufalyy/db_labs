-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema Podufalyy
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Podufalyy
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Podufalyy` DEFAULT CHARACTER SET utf8 ;
USE `Podufalyy` ;

-- -----------------------------------------------------
-- Table `Podufalyy`.`airport`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Podufalyy`.`airport` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Podufalyy`.`airline`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Podufalyy`.`airline` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Podufalyy`.`flight`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Podufalyy`.`flight` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `departure_time` TIMESTAMP(2) NOT NULL,
  `arrival_time` TIMESTAMP(2) NULL,
  `allowed_luggage_kg` FLOAT NULL,
  `departure_airport_id` INT NOT NULL,
  `arrival_airport_id` INT NOT NULL,
  `flight_id1` INT NOT NULL,
  `airline_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_flight_airport1_idx` (`departure_airport_id` ASC) VISIBLE,
  INDEX `fk_flight_airport2_idx` (`arrival_airport_id` ASC) VISIBLE,
  INDEX `fk_flight_flight2_idx` (`flight_id1` ASC) VISIBLE,
  INDEX `fk_flight_airline1_idx` (`airline_id` ASC) VISIBLE,
  CONSTRAINT `fk_flight_airport1`
    FOREIGN KEY (`departure_airport_id`)
    REFERENCES `Podufalyy`.`airport` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_flight_airport2`
    FOREIGN KEY (`arrival_airport_id`)
    REFERENCES `Podufalyy`.`airport` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_flight_flight2`
    FOREIGN KEY (`flight_id1`)
    REFERENCES `Podufalyy`.`flight` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_flight_airline1`
    FOREIGN KEY (`airline_id`)
    REFERENCES `Podufalyy`.`airline` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Podufalyy`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Podufalyy`.`user` (
  `id` INT NOT NULL,
  `username` VARCHAR(16) NOT NULL,
  `email` VARCHAR(255) NULL,
  `password` VARCHAR(32) NOT NULL,
  `flight_id` INT NOT NULL,
  INDEX `fk_user_flight1_idx` (`flight_id` ASC) VISIBLE,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_user_flight1`
    FOREIGN KEY (`flight_id`)
    REFERENCES `Podufalyy`.`flight` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `Podufalyy`.`buyed_flight`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Podufalyy`.`buyed_flight` (
  `id` INT NOT NULL,
  `id_user` INT NOT NULL,
  `id_flight` INT NOT NULL,
  `user_id` INT NOT NULL,
  `flight_id` INT NOT NULL,
  PRIMARY KEY (`id`, `id_user`, `id_flight`, `user_id`, `flight_id`),
  INDEX `fk_buyed_flight_user1_idx` (`user_id` ASC) VISIBLE,
  INDEX `fk_buyed_flight_flight1_idx` (`flight_id` ASC) VISIBLE,
  CONSTRAINT `fk_buyed_flight_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `Podufalyy`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_buyed_flight_flight1`
    FOREIGN KEY (`flight_id`)
    REFERENCES `Podufalyy`.`flight` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
