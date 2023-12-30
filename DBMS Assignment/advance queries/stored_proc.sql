
-- proc 1 - percentage

DROP PROCEDURE percentage;
DROP PROCEDURE student_grade;

CREATE PROCEDURE percentage(@roll_no AS SMALLINT, @out_of AS SMALLINT = 10)
AS 
SELECT
s.reg_no AS Student_Roll_No,
CONCAT(s.first_name, ' ', s.last_name) AS Student_Name,
	(CASE WHEN (SUM(ar.marks_obt)/COUNT(ar.marks_obt))*@out_of > 0
		  THEN (SUM(ar.marks_obt)/COUNT(ar.marks_obt))*@out_of
		  ELSE 'No assignment submitted'
		  END) AS Percentage
FROM
students AS s INNER JOIN assignment_results AS ar
ON s.reg_no = ar.student_id
INNER JOIN classes AS c
ON c.id = ar.class_id
INNER JOIN assignments as a
ON a.id = ar.assignment_id
WHERE s.reg_no = @roll_no
GROUP BY s.reg_no, CONCAT(s.first_name, ' ', s.last_name);

EXEC percentage @roll_no = 135;

EXEC percentage @roll_no = 110;

-- proc 2 - student grade

CREATE PROCEDURE student_grade(
	@roll_no AS SMALLINT, 
	@out_of AS SMALLINT = 10, 
	@grade AS VARCHAR(23) OUTPUT
)
AS
BEGIN
DECLARE @percentage AS SMALLINT

SELECT 
    @percentage = 
		  (CASE WHEN (SUM(ar.marks_obt)/COUNT(ar.marks_obt))*@out_of > 0
		  THEN (SUM(ar.marks_obt)/COUNT(ar.marks_obt))*@out_of
		  ELSE -1
		  END)
FROM assignment_results as ar
WHERE student_id = @roll_no;

IF @percentage = -1
	BEGIN
		SELECT @percentage, 'No assignment submitted';
		SET @grade = '-1'
	END
ELSE
	IF @percentage > 90
		SET @grade = 'A'
	ELSE IF @percentage > 80
		SET @grade = 'B'
	ELSE IF @percentage > 70
		SET @grade = 'C'
	ELSE IF @percentage > 60
		SET @grade = 'D'
	ELSE IF @percentage > 50
		SET @grade = 'E'
	ELSE
		SET @grade = 'F'

END;

DECLARE @result VARCHAR(1)
EXEC student_grade @roll_no = 135, @grade = @result OUTPUT
SELECT @result AS 'Grade';

DECLARE @result VARCHAR(1)
EXEC student_grade @roll_no = 110, @grade = @result OUTPUT
SELECT @result AS 'Grade';
