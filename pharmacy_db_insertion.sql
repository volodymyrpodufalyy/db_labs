USE pharmacy_db;


INSERT INTO street (name) VALUES ('Kobilnyka'),
('Dmytra Vitovskogo'), ('Shyroka'),  ( 'Svobody Ave'),( 'Kyivska'),
( 'Rynok square'),('Wesela'), ('Knyahyni Olhy'), ('Shevchenka'),( 'Horodotska');

INSERT INTO position ( name) VALUES ( 'accountant'),
('loader'),('assistant'),('technician'),('pharmacist'),
('consultant'),('manager'),('pharmacologist');

INSERT INTO pharmacy (id, name,street_id, building_number, web_adress, time_opens, 
time_closes, is_open_saturday, is_open_sunday)
 VALUES ('1', 'Apteka','1', '23', 'www.apteka1.com', '9:00', '18:00', '1', '1'),
 ('2', 'biomed','4', '12', 'www.biomed.ua', '00:00', '00:00', '1', '1'),
 ('3', 'Apteka anc','8', '1', 'www.anc.com', '10:00', '21:00', '1', '0'),
 ('4', 'Znahar','4', '4', 'www.znahar.org', '6:00', '22:00', '1', '1'),
 ('5', 'Apteka24','1', '5', 'www.apteka24.ua', '9:00', '17:00', '1', '0'),
 ('6', 'Podorozhnyk','7', '32', 'www.podorozhnyk.com', '13:00', '18:00', '1', '0'),
 ('7', 'Apteka Dobrogo Dnya','1', '13', 'www.aptekaforyou.com', '10:00', '16:00', '1', '1'),
 ('8', 'AptekaIot', '4','21', 'www.iotapteka.com', '8:30', '00:00', '1', '1'),
 ('9', 'Union Pharmacy','3', '1', 'www.pharmacy.ua', '10:00', '17:00', '1', '0'),
 ('10', 'Zelena Apteka', '2','42', 'www.zelanaapt.ua', '9:45', '21:45', '0', '0');


INSERT INTO effect_zone (name) VALUES 
('heart'), ('muscles'), ('eyes'),('tooth'), ('liver'),
('hair'),('mouth'),('neck'),('bones'), ('stomach');


INSERT INTO employee (name, surname, middle_name, identity_number, passport_data, experience, birth_date, position_id, pharmacy_id) VALUES 
('John', 'Smith', 'Kerry', '124gfg32', '0732648270', '1', '1920-02-10', '1', '1'),
('John', 'Taggart', 'Patrick', '2124gfg32', '073348270', '2', '1920-02-10', '2', '2'),
('Henry', 'Galt', 'Lewis', '12d4dfdgfg323', '0739628270', '3', '1921-01-12', '3', '3'),
('James', 'Taggart', 'Artur', '12d4dfdgfg3234', '0732623270', '4', '1919-06-12', '4', '4'),
('Eddie', 'Willers', 'Ellis', '5dddg323', '0980648270', '5', '1920-04-05', '5', '5'),
('Hugh', 'Akston', 'Elliot', '5dddg3236', '028378270', '6', '1920-02-06', '6', '6'),
('John', 'Oleynik', 'Jeffrey', '75dsss323', '0902648270', '7', '1920-12-12', '7', '7'),
('Floyd', 'Ferris', 'Ferguson', '875dsss323', '0432648270', '8', '1920-12-12', '8', '8'),
('Richard', 'Halley', 'Charley', '75dxxpo3239', '0562648290', '1', '1922-01-01', '9', '9'),
('Philip', 'Rearden', 'Artur', '234870923', '0452648270', '2', '1920-10-10', '10', '10');


INSERT INTO medicine (name, ministry_code, require_recipe, is_narcotic, is_psychtropic) VALUES 
('Phenazepam', '1013543451', '1', '1', '1'),
('Mezym', '0072396854', '0', '0', '0'),
('Imet', '902874869', '0', '0', '0'),
('Novokaine', '902874869', '1', '0', '0'),
 ('Fucis', '40515959', '0', '0', '0'),
 ('Lirika', '2545562640', '1', '0', '0'),
 ('Morphine', '56265962', '1', '1', '1'),
 ('Levomikol', '9626259', '0', '0', '0'),
('Sonmeale', '598829526', '0', '0', '0'),
('Bifren', '5845454498', '0', '0', '0');

INSERT INTO medicine_zone (medicine_id, zone_id) VALUES 
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6),
(7, 7),
(8, 8),
(9, 9),
(10, 10);

INSERT INTO pharmaсy_has_medicine (pharmacy_id, medicine_id) VALUES 
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6),
(7, 7),
(8, 8),
(9, 9),
(10, 10);
