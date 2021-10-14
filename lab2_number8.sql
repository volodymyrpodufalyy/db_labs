SELECT *, avg(price)
FROM labor_sql.pc 
where speed > 600
group by speed