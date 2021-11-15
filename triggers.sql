use pharmacy_db;

drop trigger if exists position_update;

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
DELIMITER ;
