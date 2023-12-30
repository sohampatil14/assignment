/*
	1. delete
	2. update
*/

CREATE TABLE temp_table1 (
id SMALLINT PRIMARY KEY,
val VARCHAR(30)
);


CREATE TABLE temp_table2 (
id SMALLINT PRIMARY KEY,
val VARCHAR(30)
);

INSERT INTO temp_table1 
VALUES (1, 'Aarav Gupta'),
	   (2, 'Nisha Patel'),
	   (3, 'Rahul Sharma'),
	   (5, 'Priya Singhania');


INSERT INTO temp_table2
VALUES (1, 'Arjun Kapoor'),
	   (2, 'Meera Chatterjee'),
	   (4, 'Rohan Desai'),
	   (5, 'Sanya Verma');

SELECT * FROM temp_table1;
GO

DELETE FROM temp_table1
WHERE id = 1;

SELECT * FROM temp_table1;
GO

SELECT * FROM temp_table2;
GO

UPDATE temp_table2
SET val = 'Arjun Rajput'
WHERE id = 1;

SELECT * FROM temp_table2;
GO

DROP TABLE temp_table1;
DROP TABLE temp_table2;