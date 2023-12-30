CREATE TRIGGER add_marks ON classes 
AFTER INSERT 
AS
BEGIN
    UPDATE c SET total_marks = (c.internal_marks + c.exam_marks)
    FROM classes AS c
    INNER JOIN inserted AS i ON c.id = i.id;
END;

INSERT INTO classes (name, type, internal_marks, exam_marks) 
VALUES ('English Literature', 'Theory', 20, 80);

INSERT INTO classes (name, type, internal_marks, exam_marks) 
VALUES ('English Language', 'Theory', 35, 65);

INSERT INTO classes (name, type, internal_marks, exam_marks) 
VALUES ('Hindi', 'Theory', 20, 80);

INSERT INTO classes (name, type, internal_marks, exam_marks) 
VALUES ('Language 3', 'Theory', 20, 80);

INSERT INTO classes (name, type, internal_marks, exam_marks) 
VALUES ('History', 'Theory', 30, 70);

INSERT INTO classes (name, type, internal_marks, exam_marks) 
VALUES ('Geography', 'Theory', 30, 70);

INSERT INTO classes (name, type, internal_marks, exam_marks) 
VALUES ('Physics', 'Theory', 35, 65);

INSERT INTO classes (name, type, internal_marks, exam_marks) 
VALUES ('Chemistry', 'Theory', 35, 65);

INSERT INTO classes (name, type, internal_marks, exam_marks) 
VALUES ('Biology', 'Theory', 35, 65);

INSERT INTO classes (name, type, internal_marks, exam_marks) 
VALUES ('Physics', 'Practical', 20, 30);

INSERT INTO classes (name, type, internal_marks, exam_marks) 
VALUES ('Chemistry', 'Practical', 20, 30);

INSERT INTO classes (name, type, internal_marks, exam_marks) 
VALUES ('Biology', 'Practical', 20, 30);

INSERT INTO classes (name, type, internal_marks, exam_marks) 
VALUES ('Mathematics', 'Theory', 30, 70);

INSERT INTO classes (name, type, internal_marks, exam_marks) 
VALUES ('Physical Education', 'Practical', 25, 25);

select * from classes;

--dbcc checkident('classes', reseed, 0);