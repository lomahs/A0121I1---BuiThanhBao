USE classicmodels;

CREATE VIEW customer_view AS
SELECT customerNumber,customerName,phone
FROM customers;

SELECT *
FROM customer_view;

CREATE OR REPLACE VIEW customer_view AS
SELECT *
FROM customers
WHERE city = 'Nantes';

ALTER TABLE p