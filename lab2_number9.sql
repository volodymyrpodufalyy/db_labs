SELECT * FROM 
(SELECT `name`, numGuns, bore, displacement, type, country, launched, classes.class, 
(numGuns=8) + (bore=15) + (displacement=32000) + (type='bb') + (country='USA') + 
(launched=1915) + (classes.class='Kon') AS n
FROM ships JOIN classes ON ships.class  = classes.class) T WHERE n >= 4;