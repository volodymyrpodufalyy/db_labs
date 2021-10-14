SELECT
Product.type,
Product.model,
avg(selection.price) as average_price
FROM Product
JOIN (SELECT model, price FROM PC
UNION
SELECT model, price FROM Printer
UNION
SELECT model, price FROM Laptop
) AS selection ON product.model = selection.model
GROUP BY 2;