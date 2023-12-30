INSERT INTO assignments(name, class_id, passing_marks, max_marks) 
VALUES ('Poem Rhyming Scheme', 1, 4, 10);

INSERT INTO assignments(name, class_id, passing_marks, max_marks) 
VALUES ('Lesson 1 Hard Words', 1, 4, 10);

INSERT INTO assignments(name, class_id, passing_marks, max_marks) 
VALUES ('Adjectives', 2, 4, 10);

INSERT INTO assignments(name, class_id, passing_marks, max_marks) 
VALUES ('Verbs', 2, 4, 10);

INSERT INTO assignments(name, class_id, passing_marks, max_marks) 
VALUES ('निबन्ध', 3, 4, 10);

INSERT INTO assignments(name, class_id, passing_marks, max_marks) 
VALUES ('लेखक परिचय', 3, 4, 10);

INSERT INTO assignments(name, class_id, passing_marks, max_marks) 
VALUES ('Opium War', 5, 4, 10);

INSERT INTO assignments(name, class_id, passing_marks, max_marks) 
VALUES ('European Renaissance', 5, 4, 10);

INSERT INTO assignments(name, class_id, passing_marks, max_marks) 
VALUES ('Rock Formation', 6, 4, 10);

INSERT INTO assignments(name, class_id, passing_marks, max_marks) 
VALUES ('Volcanoes in New Zealand', 6, 4, 10);

INSERT INTO assignments(name, class_id, passing_marks, max_marks) 
VALUES ('Acceleration of a Falling Body', 7, 4, 10);

INSERT INTO assignments(name, class_id, passing_marks, max_marks) 
VALUES ('Ohm''s Law', 7, 4, 10);

INSERT INTO assignments(name, class_id, passing_marks, max_marks) 
VALUES ('Types of Reactions', 8, 4, 10);

INSERT INTO assignments(name, class_id, passing_marks, max_marks) 
VALUES ('Atomic Weight', 8, 4, 10);

INSERT INTO assignments(name, class_id, passing_marks, max_marks) 
VALUES ('Muscle Cells', 9, 4, 10);

INSERT INTO assignments(name, class_id, passing_marks, max_marks) 
VALUES ('Photosynthesis', 9, 4, 10);

INSERT INTO assignments(name, class_id, passing_marks, max_marks) 
VALUES ('Pythagora''s Theorem', 13, 4, 10);

INSERT INTO assignments(name, class_id, passing_marks, max_marks) 
VALUES ('Complex Analysis', 13, 4, 10);

select * from assignments;

select c.name as Class_Name, a.name as Assignment_Name
from classes as c inner join assignments as a
on c.id = a.class_id;