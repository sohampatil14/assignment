INSERT INTO class_by_teachers VALUES (1, 13);
INSERT INTO class_by_teachers VALUES (2, 5);
INSERT INTO class_by_teachers VALUES (3, 1);
INSERT INTO class_by_teachers VALUES (4, 11);
INSERT INTO class_by_teachers VALUES (5, 6);
INSERT INTO class_by_teachers VALUES (6, 8);
INSERT INTO class_by_teachers VALUES (7, 12);
INSERT INTO class_by_teachers VALUES (8, 2);
INSERT INTO class_by_teachers VALUES (9, 7);
INSERT INTO class_by_teachers VALUES (10, 9);
INSERT INTO class_by_teachers VALUES (11, 3);
INSERT INTO class_by_teachers VALUES (12, 4);
INSERT INTO class_by_teachers VALUES (13, 14);
INSERT INTO class_by_teachers VALUES (14, 10);

select * from class_by_teachers;

select 
c.name as Class_Name, 
CONCAT(t.first_name, ' ', t.last_name) as Teacher_Name
from 
classes as c inner join class_by_teachers as ct
on c.id = ct.class_id
inner join teachers as t
on t.id = ct.teacher_id;