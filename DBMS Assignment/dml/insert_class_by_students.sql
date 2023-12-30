INSERT INTO class_by_students VALUES (7, 120);
INSERT INTO class_by_students VALUES (5, 150);
INSERT INTO class_by_students VALUES (13, 135);
INSERT INTO class_by_students VALUES (14, 118);
INSERT INTO class_by_students VALUES (13, 156);
INSERT INTO class_by_students VALUES (1, 129);
INSERT INTO class_by_students VALUES (14, 167);
INSERT INTO class_by_students VALUES (8, 123);
INSERT INTO class_by_students VALUES (10, 146);
INSERT INTO class_by_students VALUES (11, 117);
INSERT INTO class_by_students VALUES (12, 133);
INSERT INTO class_by_students VALUES (1, 147);
INSERT INTO class_by_students VALUES (10, 117);
INSERT INTO class_by_students VALUES (2, 119);
INSERT INTO class_by_students VALUES (7, 165);
INSERT INTO class_by_students VALUES (14, 180);
INSERT INTO class_by_students VALUES (4, 159);
INSERT INTO class_by_students VALUES (7, 169);
INSERT INTO class_by_students VALUES (13, 138);
INSERT INTO class_by_students VALUES (7, 108);
INSERT INTO class_by_students VALUES (8, 180);
INSERT INTO class_by_students VALUES (7, 114);
INSERT INTO class_by_students VALUES (13, 124);
INSERT INTO class_by_students VALUES (1, 119);
INSERT INTO class_by_students VALUES (13, 132);
INSERT INTO class_by_students VALUES (13, 106);
INSERT INTO class_by_students VALUES (13, 139);
INSERT INTO class_by_students VALUES (4, 137);
INSERT INTO class_by_students VALUES (14, 116);
INSERT INTO class_by_students VALUES (11, 132);
INSERT INTO class_by_students VALUES (7, 152);
INSERT INTO class_by_students VALUES (1, 135);
INSERT INTO class_by_students VALUES (1, 109);
INSERT INTO class_by_students VALUES (9, 107);
INSERT INTO class_by_students VALUES (5, 147);
INSERT INTO class_by_students VALUES (7, 165);
INSERT INTO class_by_students VALUES (1, 122);
INSERT INTO class_by_students VALUES (10, 135);
INSERT INTO class_by_students VALUES (2, 143);
INSERT INTO class_by_students VALUES (1, 105);
INSERT INTO class_by_students VALUES (9, 111);
INSERT INTO class_by_students VALUES (9, 126);
INSERT INTO class_by_students VALUES (2, 154);
INSERT INTO class_by_students VALUES (7, 179);
INSERT INTO class_by_students VALUES (7, 102);
INSERT INTO class_by_students VALUES (11, 105);
INSERT INTO class_by_students VALUES (3, 118);
INSERT INTO class_by_students VALUES (3, 138);
INSERT INTO class_by_students VALUES (5, 107);

select * from class_by_students;

select 
CONCAT(s.first_name, ' ', s.last_name) as Student_Name,
c.name as Class_Name
from classes as c inner join class_by_students as cs
on c.id = cs.class_id
inner join students as s 
on s.reg_no = cs.student_id;

select APPROX_COUNT_DISTINCT(class_id), APPROX_COUNT_DISTINCT(student_id)
from class_by_students