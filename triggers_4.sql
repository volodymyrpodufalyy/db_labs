drop trigger if exists street_logs;

CREATE TABLE street_journal (
  id INT NOT NULL auto_increment,
  name INT NOT NULL,
  timestamp timestamp,
  PRIMARY KEY (medicine_id, zone_id)
  );
  

DELIMITER //
CREATE TRIGGER  street_logs
AFTER delete
on street 
for each row 
begin
INSERT INTO street_journal(name, timestamp) values 	(new.name, current_timestamp());
end //
DELIMITER ;