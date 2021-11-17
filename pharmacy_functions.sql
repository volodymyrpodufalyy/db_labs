
USE pharmacy_db;
SET GLOBAL log_bin_trust_function_creators = 1;

DROP FUNCTION IF EXISTS get_average_experience;
DROP FUNCTION IF EXISTS get_position_name;

DELIMITER //
CREATE FUNCTION get_average_experience()
RETURNS DECIMAL(10,1) 
BEGIN
return(SELECT AVG(experience) FROM employee);
END //	
DELIMITER ;

-- SELECT * from employee where experience > get_average_experience();

DELIMITER //	
CREATE FUNCTION get_position_name(
position_id INT
)
RETURNS VARCHAR(25)
BEGIN	
RETURN(
	select name from position where id =(select position_id from employee where id = position_id)
);
END //
DELIMITER ;


-- SELECT name, surname, middle_name, identity_number, passport_data, experience, birth_date, get_position_name(id) from employee;
