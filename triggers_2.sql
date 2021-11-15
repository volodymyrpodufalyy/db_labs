drop trigger if exists identity_number_format;

DELIMITER //
CREATE TRIGGER  identity_number_format
 before insert
    on employee
    for each row
begin
 if (new.identity_number  rlike '.*(?<!00)$') then
		signal sqlstate '45000'
        set message_text = 'identity_number must not end with 2 zeros';
    end if;
end
//
DELIMITER ;