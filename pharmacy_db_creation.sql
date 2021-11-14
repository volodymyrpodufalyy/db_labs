CREATE DATABASE IF NOT EXISTS pharmacy_db;
USE pharmacy_db;
 
DROP TABLE IF EXISTS pharmaсy_has_medicine;
DROP TABLE IF EXISTS medicine;
DROP TABLE IF EXISTS medicine_zone;
DROP TABLE IF EXISTS pharmacy;
DROP TABLE IF EXISTS employee;
DROP TABLE IF EXISTS position;
DROP TABLE IF EXISTS effect_zone;
DROP TABLE IF EXISTS street;


CREATE TABLE street(
id INT NOT NULL AUTO_INCREMENT,
name VARCHAR(45) NOT NULL,
PRIMARY KEY(id)
);


CREATE TABLE effect_zone (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL,
  PRIMARY KEY (id)
  );


CREATE TABLE position (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(25) NOT NULL,
  PRIMARY KEY (id)
  );
  

  CREATE TABLE employee (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL,
  surname VARCHAR(45) NOT NULL,
  middle_name VARCHAR(45) NOT NULL,
  identity_number VARCHAR(20) NOT NULL,
  passport_data VARCHAR(20) NOT NULL,
  experience DECIMAL(10,1) NOT NULL,
  birth_date DATE NOT NULL,
  position_id VARCHAR(25) NOT NULL,
  pharmacy_id INT NOT NULL,
  PRIMARY KEY (id)
  );
  
CREATE TABLE medicine (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(20) NOT NULL,
  ministry_code VARCHAR(15) NOT NULL,
  require_recipe BOOLEAN NOT NULL,
  is_narcotic BOOLEAN NULL,
  is_psychtropic BOOLEAN NULL,
  PRIMARY KEY (id)
);

CREATE TABLE pharmacy (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL,
  street_id VARCHAR(45) NOT NULL,
  building_number INT NOT NULL,
  web_adress VARCHAR(45) NULL,
  time_opens TIME NOT NULL,
  time_closes TIME NOT NULL,
  is_open_saturday BOOLEAN NOT NULL,
  is_open_sunday BOOLEAN NOT NULL,
  PRIMARY KEY (id)
  );
  

CREATE TABLE medicine_zone (
  medicine_id INT NOT NULL,
  zone_id INT NOT NULL,
  PRIMARY KEY (medicine_id, zone_id)
  );
  

CREATE TABLE pharmaсy_has_medicine (
  pharmacy_id INT NOT NULL,
  medicine_id INT NOT NULL,
  PRIMARY KEY (pharmacy_id, medicine_id)
  );