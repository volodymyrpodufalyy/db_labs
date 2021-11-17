USE pharmacy_db;

-- 1 -- 
DROP PROCEDURE IF EXISTS insert_into_pharmacy;
drop procedure if exists create_random_tables;
drop procedure if exists select_medicine_zone;


DELIMITER //
CREATE PROCEDURE insert_into_pharmacy(
name VARCHAR (45),
 building_number INT,
  web_adress VARCHAR(45),
   time_opens TIME,
   time_closes TIME,
   is_open_saturday BOOLEAN,
   is_open_sunday BOOLEAN
)
BEGIN
INSERT INTO pharmacy(name, building_number,web_adress,time_opens,time_closes,is_open_saturday,is_open_sunday )
VALUES(name, building_number,web_adress,work_time_open,work_time_close,is_open_saturday,is_open_sunday )
;
END //


-- 2


DELIMITER //
CREATE PROCEDURE select_medicine_zone()
BEGIN
SELECT * from medicine_zone
 join medicine on medicine.id = medicine_zone.medicine_id
join effect_zone on effect_zone.id = medicine_zone.zone_id;
END //

-- 3 --


DELIMITER //
create procedure create_random_tables()
begin
declare done bool default false;
declare new_id int;
declare new_name varchar(45);

DECLARE zones cursor
for select  * from effect_zone;

DECLARE CONTINUE HANDLER FOR
not found set done = true ;
	
    drop table if exists effect_zone_1;
	drop table if exists effect_zone_2;
    
    create table effect_zone_1 like effect_zone;
    create table effect_zone_2 like effect_zone;
    
     open zones;
     
     effect_zone_loop:
				LOOP
						fetch zones into new_id, new_name ;
                        if done then 
								leave effect_zone_loop;
                                END IF;
						if rand() > 0.5 then
                        insert into effect_zone_1(name) values (new_name);
                        ELSE
                        insert into effect_zone_2 (name) values (new_name);
                        END IF;
                        END LOOP;
                        CLOSE zones;
                        
end// 

call create_random_tables;
