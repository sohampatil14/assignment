INSERT INTO assignment_results VALUES (1, 1, 129, 8.5);
INSERT INTO assignment_results VALUES (1, 1, 147, 8.4);
INSERT INTO assignment_results VALUES (1, 1, 119, 4.7);
INSERT INTO assignment_results VALUES (1, 1, 135, 5.3);
INSERT INTO assignment_results VALUES (1, 1, 109, 6.1);
INSERT INTO assignment_results VALUES (1, 1, 122, 4.0);
INSERT INTO assignment_results VALUES (1, 1, 105, 3.2);
INSERT INTO assignment_results VALUES (2, 1, 129, 4.9);
INSERT INTO assignment_results VALUES (2, 1, 147, 9.5);
INSERT INTO assignment_results VALUES (2, 1, 119, 4.5);
INSERT INTO assignment_results VALUES (2, 1, 135, 9.7);
INSERT INTO assignment_results VALUES (2, 1, 109, 6.1);
INSERT INTO assignment_results VALUES (2, 1, 122, 9.3);
INSERT INTO assignment_results VALUES (2, 1, 105, 6.4);
INSERT INTO assignment_results VALUES (3, 2, 119, 8.4);
INSERT INTO assignment_results VALUES (3, 2, 143, 2.3);
INSERT INTO assignment_results VALUES (3, 2, 154, 7.2);
INSERT INTO assignment_results VALUES (4, 2, 119, 6.9);
INSERT INTO assignment_results VALUES (4, 2, 143, 9.2);
INSERT INTO assignment_results VALUES (4, 2, 154, 5.1);
INSERT INTO assignment_results VALUES (5, 3, 118, 4.5);
INSERT INTO assignment_results VALUES (5, 3, 138, 8.2);
INSERT INTO assignment_results VALUES (6, 3, 118, 5.8);
INSERT INTO assignment_results VALUES (6, 3, 138, 9.3);
INSERT INTO assignment_results VALUES (7, 5, 150, 6.1);
INSERT INTO assignment_results VALUES (7, 5, 147, 2.2);
INSERT INTO assignment_results VALUES (7, 5, 107, 2.8);
INSERT INTO assignment_results VALUES (8, 5, 150, 5.4);
INSERT INTO assignment_results VALUES (8, 5, 147, 4.4);
INSERT INTO assignment_results VALUES (8, 5, 107, 5.3);
INSERT INTO assignment_results VALUES (11, 7, 120, 2.2);
INSERT INTO assignment_results VALUES (11, 7, 165, 2.5);
INSERT INTO assignment_results VALUES (11, 7, 169, 8.7);
INSERT INTO assignment_results VALUES (11, 7, 108, 8.3);
INSERT INTO assignment_results VALUES (11, 7, 114, 8.1);
INSERT INTO assignment_results VALUES (11, 7, 152, 4.0);
INSERT INTO assignment_results VALUES (11, 7, 165, 5.9);
INSERT INTO assignment_results VALUES (11, 7, 179, 9.6);
INSERT INTO assignment_results VALUES (11, 7, 102, 5.8);
INSERT INTO assignment_results VALUES (12, 7, 120, 7.9);
INSERT INTO assignment_results VALUES (12, 7, 165, 6.5);
INSERT INTO assignment_results VALUES (12, 7, 169, 3.8);
INSERT INTO assignment_results VALUES (12, 7, 108, 6.8);
INSERT INTO assignment_results VALUES (12, 7, 114, 8.4);
INSERT INTO assignment_results VALUES (12, 7, 152, 6.4);
INSERT INTO assignment_results VALUES (12, 7, 165, 3.8);
INSERT INTO assignment_results VALUES (12, 7, 179, 6.6);
INSERT INTO assignment_results VALUES (12, 7, 102, 4.8);
INSERT INTO assignment_results VALUES (13, 8, 123, 7.4);
INSERT INTO assignment_results VALUES (13, 8, 180, 5.9);
INSERT INTO assignment_results VALUES (14, 8, 123, 5.8);
INSERT INTO assignment_results VALUES (14, 8, 180, 8.1);
INSERT INTO assignment_results VALUES (15, 9, 107, 4.2);
INSERT INTO assignment_results VALUES (15, 9, 111, 2.7);
INSERT INTO assignment_results VALUES (15, 9, 126, 4.8);
INSERT INTO assignment_results VALUES (16, 9, 107, 9.1);
INSERT INTO assignment_results VALUES (16, 9, 111, 5.2);
INSERT INTO assignment_results VALUES (16, 9, 126, 5.1);
INSERT INTO assignment_results VALUES (17, 13, 135, 9.6);
INSERT INTO assignment_results VALUES (17, 13, 156, 6.6);
INSERT INTO assignment_results VALUES (17, 13, 138, 4.7);
INSERT INTO assignment_results VALUES (17, 13, 124, 5.7);
INSERT INTO assignment_results VALUES (17, 13, 132, 2.4);
INSERT INTO assignment_results VALUES (17, 13, 106, 4.4);
INSERT INTO assignment_results VALUES (17, 13, 139, 9.7);
INSERT INTO assignment_results VALUES (18, 13, 135, 6.8);
INSERT INTO assignment_results VALUES (18, 13, 156, 4.0);
INSERT INTO assignment_results VALUES (18, 13, 138, 9.7);
INSERT INTO assignment_results VALUES (18, 13, 124, 5.5);
INSERT INTO assignment_results VALUES (18, 13, 132, 6.6);
INSERT INTO assignment_results VALUES (18, 13, 106, 3.0);
INSERT INTO assignment_results VALUES (18, 13, 139, 2.9);

select * from assignment_results;

select student_id as Student_ID, 
sum(marks_obt) as Total_Marks
from assignment_results 
group by student_id
order by Total_Marks desc;
