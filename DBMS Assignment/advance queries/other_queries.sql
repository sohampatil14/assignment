/*
	1. Select into
	2. Insert into select
    3. Views
	4. Null Values
    5. Null functions
*/

-- select into

SELECT TOP 3
s.reg_no as Student_Roll_No,
CONCAT(s.first_name, ' ', s.last_name) as Student_Name,
c.name as Class_Name,
a.name as Assignment_Name,
ar.marks_obt as Marks_Obtained
INTO top_3_in_european_renaissance
FROM
students AS s INNER JOIN assignment_results AS ar
ON s.reg_no = ar.student_id
INNER JOIN classes AS c
ON c.id = ar.class_id
INNER JOIN assignments as a
ON a.id = ar.assignment_id
WHERE c.name = 'History' AND a.name = 'European Renaissance'
ORDER BY ar.marks_obt DESC, s.reg_no DESC;

SELECT * FROM top_3_in_european_renaissance;

DROP TABLE top_3_in_european_renaissance;

-- insert into select

CREATE TABLE temp_table1 (
id SMALLINT PRIMARY KEY,
val VARCHAR(30)
);

CREATE TABLE temp_table_cpy (
id_cpy SMALLINT PRIMARY KEY,
val_cpy VARCHAR(30)
);


INSERT INTO temp_table1 
VALUES (1, 'Aarav Gupta'),
	   (2, 'Nisha Patel'),
	   (3, 'Rahul Sharma'),
	   (5, 'Priya Singhania');

INSERT INTO 
temp_table_cpy (id_cpy, val_cpy)
SELECT * FROM temp_table1;

SELECT * FROM temp_table_cpy;

DROP TABLE temp_table_cpy;
DROP TABLE temp_table1;

-- views

CREATE VIEW top_10_in_complex_analysis AS
SELECT TOP 10
s.reg_no as Student_Roll_No,
CONCAT(s.first_name, ' ', s.last_name) as Student_Name,
c.name as Class_Name,
a.name as Assignment_Name,
ar.marks_obt as Marks_Obtained
FROM
students AS s INNER JOIN assignment_results AS ar
ON s.reg_no = ar.student_id
INNER JOIN classes AS c
ON c.id = ar.class_id
INNER JOIN assignments as a
ON a.id = ar.assignment_id
WHERE c.name = 'Mathematics' AND a.name = 'Complex Analysis'
ORDER BY ar.marks_obt DESC, s.reg_no DESC;

SELECT * FROM top_10_in_complex_analysis;

DROP VIEW top_10_in_complex_analysis;

-- null values

SELECT * 
FROM students
WHERE dob IS NULL;

-- null functions

-- ISNULL() function is used to replace NULL values. 
-- COALESCE() returns the first non-NULL expression among its arguments
-- NULLIF() takes two arguments. If the two arguments are equal, then NULL is returned, else the first argument is returned

SELECT 
reg_no,
CONCAT(first_name, ' ', last_name) as Student_Name,
ISNULL('UNKNOWN', dob) as dob
FROM students;

SELECT 
reg_no,
CONCAT(first_name, ' ', last_name) as Student_Name,
COALESCE(DATEADD(YEAR, -age, CAST(GETDATE() AS DATE)), dob) as dob
FROM students;

SELECT 
NULLIF(10, 10);

SELECT 
NULLIF(10, 20);
