INSERT INTO country (name, covid_rules) VALUES
('Ukraine', 'PLR test and app'),
('USA', 'Vaccination sertificate'),
('Poland', 'PLR test and vaccination'),
('UK', 'Vaccination sertificate'),
('Spain', 'Vaccination sertificate'),
('Italy', 'Vaccination sertificate and PLR test'),
('Germany', 'Vaccination sertificate'),
('Belgium', 'Vaccination sertificate'),
('Canada', 'PLR test'),
('Egypt', 'PLR test');

INSERT INTO airline (name, country_id) VALUES
('Ukraine airlines', '1'),
('USA airlines', '2'),
('Poland airlines', '3'),
('UK airlines', '4'),
('Spain airlines', '5'),
('Italy airlines', '6'),
('Germany airlines', '7'),
('Belgium airlines', '8'),
('Canada airlines', '9'),
('Egypt airlines', '10');

INSERT INTO city (name, country_id) VALUES
('Kyiv', '1'),
('New York', '2'),
('Warsaw', '3'),
('London', '4'),
('Madrid', '5'),
('Rome', '6'),
('Berlin', '7'),
('Brussels', '8'),
('Toronto', '9'),
('Kair', '10');

INSERT INTO airport (name, country_id, city_id) VALUES
('Boryspil airport', '1', '1'),
('John F. Kennedy International Airport', '2', '2'),
('Warsaw Chopin Airport', '3', '3'),
('Haethrow airport', '4', '4'),
('Madrid-Barajas Adolfo Suárez Airport', '5', '5'),
('AEROPORTI DI ROMA', '6', '6'),
('Berlin-Tegel airport', '7', '7'),
('Brussels Airport', '8', '8'),
('Toronto Pearson International Airport', '9', '9'),
('Cairo International Airport', '10', '10');

INSERT INTO plane (name, seats, type, airline_id) VALUES
('Boeing 777', '100', 'standart', '1'),
('Boeing 772', '100', 'military', '2'),
('Boeing 737', '100', 'freight', '3'),
('Airbus A320', '100', 'military', '4'),
('Airbus A330', '100', 'freight', '5'),
('Boeing 787', '100', 'standart', '6'),
('BOEING 767-300ER', '100', 'standart', '7'),
('BOEING 737-800', '100', 'freight', '8'),
('EMBRAER-190', '100', 'standart', '9'),
('EMBRAER-195', '100', 'military', '10');

INSERT INTO crew (main_pilot, stewardess, second_pilot, plane_id) VALUES
('John Smith', 'Lola James', 'Morpheus Domrey', '1'),
('John Galt', 'Dagny Taggart', 'Ayn Rand', '2'),
('Henry Rearden', 'Francisco d Anconia', 'Nathaniel Taggart', '3'),
('James Taggart', 'Cherryl Taggart', 'Johny Sins', '4'),
('Eddie Willers', 'Lillian Rearden', 'Ragnar Danneskjold', '5'),
('Hugh Akston', 'Lola James', 'Orren Boyle', '6'),
('John Smith', 'Larisa Oleynik', 'Morpheus Domrey', '7'),
('Floyd Ferris', 'Cherryl Brooks', 'Morpheus Domrey', '8'),
('Richard Halley', 'Laura Bradford', 'Midas Mulligan', '9'),
('Philip Rearden', 'Millie Bush', 'Wesley Mouch', '10');

INSERT INTO user (name, lastname, email, password, passport_id) VALUES
('John', 'Smith', 'jhn23@gmail.com', '124gfg32', '0732648270'),
('John', 'Taggart', 'yn45@mail.com', '2124gfg32', '0732648270'),
('Henry', 'Galt', 'henr98@gmail.com', '12d4dfdgfg323', '0732658270'),
('James', 'Taggart', 'jj354@mail.com', '12d4dfdgfg3234', '0732623270'),
('Eddie', 'Willers', 'ed0ld@gmail.com', '5dddg323', '0980648270'),
('Hugh', 'Akston', 'hugh3@mail.com', '5dddg3236', '028378270'),
('John', 'Oleynik', 'jo67@gmail.com', '75dsss323', '0902648270'),
('Floyd', 'Ferris', 'floydy777@gmail.com', '875dsss323', '0432648270'),
('Richard', 'Halley', 'richrich333@gmail.com', '75dxxpo3239', '0562648290'),
('Philip', 'Rearden', 'phil44@gmail.com', '234870923', '0452648270');


INSERT INTO class (
	type, 
    benefits, 
    price) VALUES
('econom', 'none', '100'),
('premium','Food, drinks', '200'),
('business', 'Food, drinks, seats, comfort', '300');

INSERT INTO flight (
	departure_time, 
	arrival_time,
    allowed_luggage_kg, 
    connected_flight, 
    airline_id, 
    airport_id, 
    airport_country_id, 
    airport_id1,
    airport_country_id1,
    plane_id,
    class_id
    ) VALUES
('2021-10-11 10:00:00', '2021-10-11 10:00:00', '30', '2', '1', '1', '1', '2', '2', '1', '1'),
('2021-10-11 12:00:00', '2021-10-11 14:00:00', '20','1', '2', '2', '2', '3', '3', '2', '1'),
('2021-10-11 14:00:00', '2021-10-11 15:00:00', '35','2', '3', '3', '3', '4', '4', '3', '1'),
('2021-10-11 15:00:00', '2021-10-11 16:00:00', '30','3', '4', '4', '4', '5', '5', '4', '2'),
('2021-10-11 16:00:00', '2021-10-11 18:00:00', '30','4', '5', '5', '5', '6', '6', '5', '2'),
('2021-10-11 18:00:00', '2021-10-11 19:30:00', '10', '5','6', '6', '6', '7', '7', '6', '2'),
('2021-10-11 19:00:00', '2021-10-11 20:00:00', '30','8', '7', '7', '7', '8', '8', '7', '2'),
('2021-10-11 20:00:00', '2021-10-11 21:00:00', '32', '6','8', '8', '8', '9', '9', '8', '3'),
('2021-10-11 21:00:00', '2021-10-11 22:00:00', '20', '10','9', '9', '9', '10', '10', '9', '3'),
('2021-10-11 22:00:00', '2021-10-11 23:00:00', '30','7', '10', '10', '10', '1', '1', '10', '3');


INSERT INTO user_has_flight (
	user_id, 
    flight_id, 
    flight_airport_id, 
    flight_airport_country_id, 
    flight_airport_id1,
    flight_airport_country_id1,
    flight_plane_id
    ) VALUES
('1', '1', '1', '1', '2', '2', '1'),
('2','2', '2', '2', '3', '3', '2'),
('3', '3', '3', '3', '4', '4', '3'),
('4', '4', '4', '4', '5', '5', '4'),
('5', '5', '5', '5', '6', '6', '5'),
('6','6', '6', '6', '7', '7', '6'),
('7', '7', '7', '7', '8', '8', '7'),
('8','8', '8', '8', '9', '9', '8'),
('9','9', '9', '9', '10', '10', '9'),
('10', '10', '10', '10', '1', '1', '10');



