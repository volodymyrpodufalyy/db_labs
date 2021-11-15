use pharmacy_db;

drop trigger if exists street_update;
drop trigger if exists street_delete;
drop trigger if exists effect_zone_update;
drop trigger if exists effect_zone_delete;
drop trigger if exists position_update;
drop trigger if exists position_delete;
drop trigger if exists  medicine_update;
drop trigger if exists  medicine_delete;
drop trigger if exists pharmacy_create;
drop trigger if exists pharmacy_update;
drop trigger if exists employee_create;
drop trigger if exists employee_update;
drop trigger if exists medicine_zone_create;
drop trigger if exists medicine_zone_update;
drop trigger if exists pharmacy_has_medicine_create;
drop trigger if exists pharmacy_has_medicine_update;

DELIMITER //
CREATE TRIGGER street_update 
BEFORE UPDATE
on street
for EACH ROW
BEGIN 
IF (new.id != old.id and old in (select id from street)) then 
SIGNAL SQLSTATE '45000'
set MESSAGE_TEXT = 'no such data found';
end if;
end // 

DELIMITER //
CREATE TRIGGER street_delete
BEFORE delete
on street
for EACH ROW
BEGIN 
IF (old.id in (select street_id from pharmacy)) then 
SIGNAL SQLSTATE '45000'
set MESSAGE_TEXT = 'there is an emplyee with this position';
end if;
end // 

-- effects

DELIMITER //
CREATE TRIGGER effects_zone_update 
BEFORE UPDATE
on effects_zone
for EACH ROW
BEGIN 
IF (new.id != old.id and old in (select id from effects_zone)) then 
SIGNAL SQLSTATE '45000'
set MESSAGE_TEXT = 'no such data found';
end if;
end // 

DELIMITER //
CREATE TRIGGER effects_zone_delete
BEFORE delete
on effects_zone
for EACH ROW
BEGIN 
IF (old.id in (select effects_zone_id from medicine)) then 
SIGNAL SQLSTATE '45000'
set MESSAGE_TEXT = 'there is an emplyee with this position';
end if;
end // 

-- position

DELIMITER //
CREATE TRIGGER position_update 
BEFORE UPDATE
on position
for EACH ROW
BEGIN 
IF (new.id != old.id and old in (select id from position )) then 
SIGNAL SQLSTATE '45000'
set MESSAGE_TEXT = 'no such data found';
end if;
end // 

DELIMITER //
CREATE TRIGGER position_delete
BEFORE delete
on position
for EACH ROW
BEGIN 
IF (old.id in (select position_id from employee )) then 
SIGNAL SQLSTATE '45000'
set MESSAGE_TEXT = 'there is an emplyee with this position';
end if;
end // 

-- medicine 


DELIMITER //
CREATE TRIGGER medicine_update
 before update
on medicine
for each row 
BEGIN 
IF (new.id != old.id and old in (select id from medicine ))  then 
SIGNAL SQLSTATE '45000'
set MESSAGE_TEXT = 'no such data found';
end if;
end // 

CREATE TRIGGER  medicine_delete
before  DELETE 
on medicine
for each row 
BEGIN 
if (old.id in (select medicine_id from medicine_zone )) then 
signal sqlstate '45000'
 set message_text = 'there is an employee with such data, you cannot delete it';
end if;
if (old.id in (select medicine_id from pharmacy_has_medicine )) then 
signal sqlstate '45000'
 set message_text = 'there is an employee with such data, you cannot delete it';
end if;
end //	

-- pharmacy 

DELIMITER // 
create trigger 	pharmacy_create
before insert
on pharmacy
for each row
begin
	    if (new.street_id not in (select id from street)) then
			signal sqlstate '45000'
			set message_text = 'FK error. no such data found';
        end if;
        
	end//

DELIMITER // 
create trigger pharmacy_update
before update
on pharmacy
for each row 
begin
    if (new.id != old.id and old in (select id from pharmacy)) then
		signal sqlstate '45000'
        set message_text = 'no such data found';
	end if;
end//
DELIMITER ;

DELIMITER //
CREATE TRIGGER  pharmacy_delete
before  DELETE 
on pharmacy
for each row 
BEGIN 
if (old.id in (select pharmacy_id from pharmacy_has_medicine )) then 
signal sqlstate '45000'
 set message_text = 'there is an employee with such data, you cannot delete it';
end if;
end //	

-- employee

DELIMITER // 
create trigger 	employee_create
before insert
on employee
for each row
begin
	    if (new.position_id not in (select id from position)) then
			signal sqlstate '45000'
			set message_text = 'FK error. no such position found';
        end if;
        if (new.pharmacy_id not in (select id from pharmacy)) then
			signal sqlstate '45000'
			set message_text = 'FK error. no such pharmacy found';
        end if;
	end//
DELIMITER ;


DELIMITER // 
create trigger employee_update
before update
on employee
for each row 
begin
    if (new.id != old.id and old in (select id from employee)) then
		signal sqlstate '45000'
        set message_text = 'no data found';
	end if;
end//
DELIMITER ;

-- medicine zone

DELIMITER //
CREATE TRIGGER  medicine_zone_create
before INSERT on medicine_zone 
for each row 
begin
	if (new.medicine_id not in (select id from medicine)) then
		signal sqlstate '45000'
        set message_text = 'FK error. no such medicine found';
	end if;
    if (new.zone_id not in (select id from medicine_zone)) then
		signal sqlstate '45000'
        set message_text = 'FK error. no such zone found';
	end if;
end
// DELIMITER ;

DELIMITER //
CREATE TRIGGER  medicine_zone_update
before UPDATE on medicine_zone 
for each row 
begin
if (new.medicine_id != old.medicine_id and old.medicine_id in (select medicine_id from medicine)) then
		signal sqlstate '45000'
        set message_text = 'no such link in the linking table';
	end if;
    if (new.zone_id != old.zone_id and old.zone_id in (select zone_id from medicine_zone)) then
		signal sqlstate '45000'
        set message_text = 'no such link in the linking table';
	end if;
    
end
// DELIMITER ;

-- pharmacy has medicine

DELIMITER //
CREATE TRIGGER  pharmacy_has_medicine_create
before INSERT on pharmaсy_has_medicine
for each row 
begin
	if (new.medicine_id not in (select id from medicine)) then
		signal sqlstate '45000'
        set message_text = 'FK error. no such data found';
	end if;
    if (new.pharmacy_id not in (select id from pharmacy)) then
		signal sqlstate '45000'
        set message_text = 'FK error. no such data found';
	end if;
end
// DELIMITER ;

DELIMITER //
CREATE TRIGGER  pharmacy_has_medicine_update
before UPDATE on pharmaсy_has_medicine 
for each row 
begin
if (new.pharmacy_id != old.pharmacy_id and old.pharmacy_id in (select pharmacy_id from pharmacy_has_medicine )) then
		signal sqlstate '45000'
        set message_text = 'no such link in the linking table';
	end if;
    if (new.medicine_id != old.medicine_id and old.medicine_id in (select pharmacy_id from pharmacy_has_medicine )) then
		signal sqlstate '45000'
        set message_text = 'no such link in the linking table';
	end if;
end
// DELIMITER ;