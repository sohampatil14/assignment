-- DROP TABLE students;
-- DROP TABLE teachers;
-- DROP TABLE classes;
-- DROP TABLE assignments;
-- DROP TABLE class_by_students;
-- DROP TABLE class_by_teachers;
-- DROP TABLE assignment_results;

CREATE TABLE students (
    reg_no SMALLINT PRIMARY KEY IDENTITY(101, 1),
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    age INT CHECK (age >= 5),
    standard INT CHECK (standard > 0 AND standard <= 12),
    division CHAR(1) CHECK (division IN ('A', 'B', 'C')),
    phone VARCHAR(15) UNIQUE,
    dob DATE
);

CREATE TABLE teachers (
    id SMALLINT PRIMARY KEY IDENTITY(1, 1),
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
	designation VARCHAR(50) CHECK (designation in ('Assistant Teacher', 'Head Teacher', 'Guest Teacher', 'Vice Principal', 'Principal')),
    age INT CHECK (age >= 20),
    phone VARCHAR(15) UNIQUE,
    dob DATE
);

CREATE TABLE classes (
    id SMALLINT PRIMARY KEY IDENTITY(1, 1),
    name VARCHAR(50) NOT NULL,
    type VARCHAR(50) NOT NULL,
    internal_marks DECIMAL(4, 2),
    exam_marks DECIMAL(4, 2),
    total_marks DECIMAL(5, 2)
);

CREATE TABLE assignments (
    id SMALLINT PRIMARY KEY IDENTITY(1, 1),
    name VARCHAR(50) NOT NULL,
    class_id SMALLINT,
    passing_marks DECIMAL(4, 2),
    max_marks DECIMAL(5, 2),
    
    FOREIGN KEY (class_id)
        REFERENCES classes(id) ON UPDATE CASCADE
);

CREATE TABLE class_by_students (
    class_id SMALLINT,
    student_id SMALLINT,
    
    FOREIGN KEY (class_id)
        REFERENCES classes(id) ON DELETE CASCADE ON UPDATE CASCADE,
        
    FOREIGN KEY (student_id)
        REFERENCES students(reg_no) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE class_by_teachers (
    class_id SMALLINT,
    teacher_id SMALLINT,
    
    FOREIGN KEY (class_id)
        REFERENCES classes(id) ON DELETE CASCADE ON UPDATE CASCADE,
        
    FOREIGN KEY (teacher_id)
        REFERENCES teachers(id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE assignment_results (
    assignment_id SMALLINT,
    class_id SMALLINT,
    student_id SMALLINT,
    marks_obt DECIMAL(5, 2),
    
    FOREIGN KEY (assignment_id)
        REFERENCES assignments(id),
        
    FOREIGN KEY (class_id)
        REFERENCES class_by_students(class_id),
        
   FOREIGN KEY (student_id)
       REFERENCES students(reg_no)
);
