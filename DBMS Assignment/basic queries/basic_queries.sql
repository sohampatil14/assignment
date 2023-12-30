/*
distinct
where

and 
or
in
between

order by

group by
having

select top

like
wildcards
aliases
*/

-- distinct

SELECT APPROX_COUNT_DISTINCT(student_id) as Number_of_students
FROM assignment_results;

-- where

SELECT 
CONCAT(s.first_name, ' ', s.last_name) as Student_Name, 
marks_obt
FROM 
students as s INNER JOIN assignment_results as ar
ON s.reg_no = ar.student_id
WHERE marks_obt > 7;

-- and

SELECT 
CONCAT(s.first_name, ' ', s.last_name) as Student_Name, 
c.name as Class_Name,
ar.marks_obt as Marks_Obtained
FROM
students AS s INNER JOIN assignment_results AS ar
ON s.reg_no = ar.student_id
INNER JOIN classes AS c
ON c.id = ar.class_id
WHERE ar.marks_obt > 5 AND c.name = 'Mathematics';

-- or

SELECT 
CONCAT(s.first_name, ' ', s.last_name) as Student_Name, 
c.name as Class_Name,
c.type as Class_Type,
ar.marks_obt as Marks_Obtained
FROM
students AS s INNER JOIN assignment_results AS ar
ON s.reg_no = ar.student_id
INNER JOIN classes AS c
ON c.id = ar.class_id
WHERE c.name = 'Physics' AND c.type = 'Theory' OR c.name = 'Chemistry' AND c.type = 'Theory';

-- in

SELECT 
CONCAT(s.first_name, ' ', s.last_name) as Student_Name, 
c.name as Class_Name,
c.type as Class_Type,
ar.marks_obt as Marks_Obtained
FROM
students AS s INNER JOIN assignment_results AS ar
ON s.reg_no = ar.student_id
INNER JOIN classes AS c
ON c.id = ar.class_id
WHERE c.name IN ('Physics', 'Chemistry', 'Biology');

-- between

SELECT 
CONCAT(s.first_name, ' ', s.last_name) as Student_Name, 
c.name as Class_Name,
ar.marks_obt as Marks_Obtained
FROM
students AS s INNER JOIN assignment_results AS ar
ON s.reg_no = ar.student_id
INNER JOIN classes AS c
ON c.id = ar.class_id
WHERE ar.marks_obt BETWEEN 5 AND 7;

-- order by

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
ON a.id = ar.assignment_id
WHERE ar.marks_obt BETWEEN 5 AND 7
ORDER BY ar.marks_obt, s.reg_no, c.name;

-- group by and having

SELECT 
s.reg_no as Student_Roll_No,
CONCAT(s.first_name, ' ', s.last_name) as Student_Name,
SUM(ar.marks_obt) as Marks_Obtained
FROM
students AS s INNER JOIN assignment_results AS ar
ON s.reg_no = ar.student_id
INNER JOIN classes AS c
ON c.id = ar.class_id
INNER JOIN assignments as a
ON a.id = ar.assignment_id
GROUP BY CONCAT(s.first_name, ' ', s.last_name), s.reg_no
HAVING SUM(ar.marks_obt) > 15;

-- select top

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
ORDER BY ar.marks_obt DESC, s.reg_no ASC;


-- like and wildcards as aliases

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
ON a.id = ar.assignment_id
WHERE CONCAT(s.first_name, ' ', s.last_name) LIKE 'An%'
ORDER BY Student_Name;
