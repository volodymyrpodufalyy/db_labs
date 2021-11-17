drop trigger if exists ministry_code_format;
DELIMITER //
CREATE TRIGGER  ministry_code_format
before insert
on medicine
 for each row
begin
 if (new.ministry_code  rlike '[^{m, М,P,p}]{2}-[0-9]{3}-[0-9]{2}') then
		signal sqlstate '45000'
        set message_text = 'ministry must match 2 letters-3 numbers-2 numbers';
    end if;
end
//
DELIMITER ;