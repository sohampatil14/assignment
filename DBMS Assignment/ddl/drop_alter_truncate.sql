/*
	1. DROP
	2. ALTER
	3. TRUNCATE
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

-- truncate table

TRUNCATE TABLE temp_table1;
TRUNCATE TABLE temp_table2;

SELECT * FROM temp_table1;
SELECT * FROM temp_table2;

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

-- alter table

-- alter table: add column

ALTER TABLE temp_table1
ADD val2 VARCHAR(10);

SELECT * FROM temp_table1;

-- alter table: drop column

ALTER TABLE temp_table1
DROP COLUMN val2;

SELECT * FROM temp_table1;

-- alter table: rename column name

EXEC sp_rename 'temp_table1.val', 'val1', 'COLUMN';

SELECT * FROM temp_table1;

EXEC sp_rename 'temp_table1.val1', 'val', 'COLUMN';

-- alter table: drop contraint

SELECT name  
FROM sys.key_constraints  
WHERE type = 'PK' AND OBJECT_NAME(parent_object_id) = N'temp_table1'; 

ALTER TABLE temp_table1
DROP CONSTRAINT PK__temp_tab__3213E83FC49C534D;

-- alter table: adding a contraint

ALTER TABLE temp_table1
ALTER COLUMN id SMALLINT NOT NULL;

ALTER TABLE temp_table1
ADD CONSTRAINT PK_id PRIMARY KEY(id);

-- alter table: alter column data type

ALTER TABLE temp_table1
ALTER COLUMN id DECIMAL(4, 2);

SELECT * FROM temp_table1;

-- drop table

DROP TABLE temp_table1;
DROP TABLE temp_table2;
