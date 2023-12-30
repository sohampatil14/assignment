/*
Joins
	1. Inner Join
	2. Left Join
	3. Right Join
	4. Full Join 
	5. Cross Join
*/

-- inner join

SELECT 
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
ON a.id = ar.assignment_id;

-- left join

DROP TABLE temp_table1;
DROP TABLE temp_table2;

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

SELECT 
tt1.id as Table1_ID,
tt1.val as Table1_Value,
tt2.id as Table2_ID,
tt2.val as Table2_Value
FROM
temp_table1 as tt1 
LEFT JOIN 
temp_table2 as tt2
ON tt1.id = tt2.id;

-- right join 

SELECT 
tt1.id as Table1_ID,
tt1.val as Table1_Value,
tt2.id as Table2_ID,
tt2.val as Table2_Value
FROM
temp_table1 as tt1 
RIGHT JOIN 
temp_table2 as tt2
ON tt1.id = tt2.id;

-- full join 

SELECT 
tt1.id as Table1_ID,
tt1.val as Table1_Value,
tt2.id as Table2_ID,
tt2.val as Table2_Value
FROM
temp_table1 as tt1 
FULL JOIN 
temp_table2 as tt2
ON tt1.id = tt2.id;

-- cross join 

SELECT 
tt1.id as Table1_ID,
tt1.val as Table1_Value,
tt2.id as Table2_ID,
tt2.val as Table2_Value
FROM
temp_table1 as tt1 
CROSS JOIN 
temp_table2 as tt2;
