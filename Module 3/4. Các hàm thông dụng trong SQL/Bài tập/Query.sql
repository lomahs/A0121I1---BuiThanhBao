CREATE DATABASE EX4;

CREATE TABLE Fee
(
    id int PRIMARY KEY ,
    name varchar(50),
    age varchar(50),
    course varchar(50),
    amount int
);

SELECT *
FROM Fee
WHERE name = 'Huong';

SELECT sum(amount)
FROM Fee
WHERE name = 'Huong'
GROUP BY name;

SELECT name
FROM Fee
GROUP BY 1;