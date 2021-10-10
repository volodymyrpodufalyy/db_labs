SELECT SUBSTRING(name, (SELECT LOCATE(' ', name)+1)) as lastname
From labor_sql.passenger
Where SUBSTRING(name, (SELECT LOCATE(' ', name)+1)) LIKE 'C%'