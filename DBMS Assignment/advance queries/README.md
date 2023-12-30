## Advance Queries

* [Joins](#joins)
    
    1. [INNER JOIN](#1-inner-join)
    2. [LEFT JOIN](#2-left-join)
    3. [RIGHT JOIN](#3-right-join)
    4. [FULL JOIN](#4-full-join)
    5. [CROSS JOIN](#5-cross-join)

* [Other Queries](#other-queries)

    1. [SELECT INTO](#1-select-into)
    2. [INSERT INTO SELECT](#2-insert-into-select)
    3. [VIEWS](#3-views)
    4. [NULL Values](#4-null-values)
    5. [NULL Functions](#5-null-functions)

* [Stored Procedures](#stored-procedures)

### Joins

#### 1. INNER JOIN

``` sql
1> SELECT
2> s.reg_no as Student_Roll_No,
3> CONCAT(s.first_name, ' ', s.last_name) as Student_Name,
4> c.name as Class_Name,
5> a.name as Assignment_Name,
6> ar.marks_obt as Marks_Obtained
7> FROM
8> students AS s INNER JOIN assignment_results AS ar
9> ON s.reg_no = ar.student_id
10> INNER JOIN classes AS c
11> ON c.id = ar.class_id
12> INNER JOIN assignments as a
13> ON a.id = ar.assignment_id;
14> GO

Student_Roll_No Student_Name           Class_Name             Assignment_Name           Marks_Obtained
--------------- ---------------------- ---------------------- ------------------------- --------------
            129 Mahesh Raghavan        English Literature     Poem Rhyming Scheme                 8.50
            147 Anjali Bail            English Literature     Poem Rhyming Scheme                 8.40
            119 Jayant Venkatesh       English Literature     Poem Rhyming Scheme                 4.70
            135 Jayanta Parikh         English Literature     Poem Rhyming Scheme                 5.30
            109 Devi Kannan            English Literature     Poem Rhyming Scheme                 6.10
            122 Nanda Rajagopalan      English Literature     Poem Rhyming Scheme                 4.00
            105 Nandini Mann           English Literature     Poem Rhyming Scheme                 3.20
            ... ...                    ...                    ...                                 ...

(72 rows affected)
```

#### 2. LEFT JOIN

``` sql
1> SELECT
2> tt1.id as Table1_ID,
3> tt1.val as Table1_Value,
4> tt2.id as Table2_ID,
5> tt2.val as Table2_Value
6> FROM
7> temp_table1 as tt1
8> LEFT JOIN
9> temp_table2 as tt2
10> ON tt1.id = tt2.id;
11> GO
Table1_ID Table1_Value       Table2_ID Table2_Value
--------- ------------------ --------- ------------------
        1 Aarav Gupta                1 Arjun Kapoor
        2 Nisha Patel                2 Meera Chatterjee
        3 Rahul Sharma            NULL NULL
        5 Priya Singhania            5 Sanya Verma

(4 rows affected)
```

#### 3. RIGHT JOIN

``` sql
1> SELECT
2> tt1.id as Table1_ID,
3> tt1.val as Table1_Value,
4> tt2.id as Table2_ID,
5> tt2.val as Table2_Value
6> FROM
7> temp_table1 as tt1
8> RIGHT JOIN
9> temp_table2 as tt2
10> ON tt1.id = tt2.id;
11>
12> GO
Table1_ID Table1_Value       Table2_ID Table2_Value
--------- ------------------ --------- -------------------
        1 Aarav Gupta                1 Arjun Kapoor
        2 Nisha Patel                2 Meera Chatterjee
     NULL NULL                       4 Rohan Desai
        5 Priya Singhania            5 Sanya Verma

(4 rows affected)
```

#### 4. FULL JOIN

``` sql
1> SELECT
2> tt1.id as Table1_ID,
3> tt1.val as Table1_Value,
4> tt2.id as Table2_ID,
5> tt2.val as Table2_Value
6> FROM
7> temp_table1 as tt1
8> FULL JOIN
9> temp_table2 as tt2
10> ON tt1.id = tt2.id;
11> GO
Table1_ID Table1_Value         Table2_ID Table2_Value
--------- -------------------- --------- -------------------
        1 Aarav Gupta                  1 Arjun Kapoor
        2 Nisha Patel                  2 Meera Chatterjee
        3 Rahul Sharma              NULL NULL
     NULL NULL                         4 Rohan Desai
        5 Priya Singhania              5 Sanya Verma

(5 rows affected)
```

#### 5. CROSS JOIN

``` sql
1> SELECT
2> tt1.id as Table1_ID,
3> tt1.val as Table1_Value,
4> tt2.id as Table2_ID,
5> tt2.val as Table2_Value
6> FROM
7> temp_table1 as tt1
8> CROSS JOIN
9> temp_table2 as tt2;
10> GO
Table1_ID Table1_Value         Table2_ID Table2_Value
--------- -------------------- --------- -------------------
        1 Aarav Gupta                  1 Arjun Kapoor
        2 Nisha Patel                  1 Arjun Kapoor
        3 Rahul Sharma                 1 Arjun Kapoor
        5 Priya Singhania              1 Arjun Kapoor
        1 Aarav Gupta                  2 Meera Chatterjee
        2 Nisha Patel                  2 Meera Chatterjee
        3 Rahul Sharma                 2 Meera Chatterjee
        5 Priya Singhania              2 Meera Chatterjee
        1 Aarav Gupta                  4 Rohan Desai
        2 Nisha Patel                  4 Rohan Desai
        3 Rahul Sharma                 4 Rohan Desai
        5 Priya Singhania              4 Rohan Desai
        1 Aarav Gupta                  5 Sanya Verma
        2 Nisha Patel                  5 Sanya Verma
        3 Rahul Sharma                 5 Sanya Verma
        5 Priya Singhania              5 Sanya Verma

(16 rows affected)
```


### Other Queries

#### 1. SELECT INTO

``` sql
1> SELECT TOP 3
2> s.reg_no as Student_Roll_No,
3> CONCAT(s.first_name, ' ', s.last_name) as Student_Name,
4> c.name as Class_Name,
5> a.name as Assignment_Name,
6> ar.marks_obt as Marks_Obtained
7> INTO top_3_in_european_renaissance
8> FROM
9> students AS s INNER JOIN assignment_results AS ar
10> ON s.reg_no = ar.student_id
11> INNER JOIN classes AS c
12> ON c.id = ar.class_id
13> INNER JOIN assignments as a
14> ON a.id = ar.assignment_id
15> WHERE c.name = 'History' AND a.name = 'European Renaissance'
16> ORDER BY ar.marks_obt DESC, s.reg_no DESC;
17> GO

(3 rows affected)
1> SELECT * FROM top_3_in_european_renaissance;
2> GO
Student_Roll_No Student_Name      Class_Name      Assignment_Name          Marks_Obtained
--------------- ----------------- --------------- ------------------------ --------------
            150 Indrani Dey       History         European Renaissance               5.40
            107 Chandana Bose     History         European Renaissance               5.30
            147 Anjali Bail       History         European Renaissance               4.40

(3 rows affected)
```

#### 2. INSERT INTO SELECT

``` sql
1> CREATE TABLE temp_table1 (
2> id SMALLINT PRIMARY KEY,
3> val VARCHAR(30)
4> );
5>
6> CREATE TABLE temp_table_cpy (
7> id_cpy SMALLINT PRIMARY KEY,
8> val_cpy VARCHAR(30)
9> );
10>
11>
12> INSERT INTO temp_table1
13> VALUES (1, 'Aarav Gupta'),
14>        (2, 'Nisha Patel'),
15>        (3, 'Rahul Sharma'),
16>        (5, 'Priya Singhania');
17>
18> INSERT INTO
19> temp_table_cpy (id_cpy, val_cpy)
20> SELECT * FROM temp_table1;
21>
22> SELECT * FROM temp_table_cpy;
23> GO

(4 rows affected)

(4 rows affected)
id_cpy val_cpy
------ ------------------
     1 Aarav Gupta
     2 Nisha Patel
     3 Rahul Sharma
     5 Priya Singhania

(4 rows affected)
```

#### 3. Views

``` sql
1> CREATE VIEW top_10_in_complex_analysis AS
2> SELECT TOP 10
3> s.reg_no as Student_Roll_No,
4> CONCAT(s.first_name, ' ', s.last_name) as Student_Name,
5> c.name as Class_Name,
6> a.name as Assignment_Name,
7> ar.marks_obt as Marks_Obtained
8> FROM
9> students AS s INNER JOIN assignment_results AS ar
10> ON s.reg_no = ar.student_id
11> INNER JOIN classes AS c
12> ON c.id = ar.class_id
13> INNER JOIN assignments as a
14> ON a.id = ar.assignment_id
15> WHERE c.name = 'Mathematics' AND a.name = 'Complex Analysis'
16> ORDER BY ar.marks_obt DESC, s.reg_no DESC;
17> GO
1> SELECT * FROM top_10_in_complex_analysis;
2> GO
Student_Roll_No Student_Name               Class_Name        Assignment_Name        Marks_Obtained
--------------- -------------------------- ----------------- ---------------------- --------------
            138 Manu Keer                  Mathematics       Complex Analysis                 9.70
            135 Jayanta Parikh             Mathematics       Complex Analysis                 6.80
            132 Jarita Bhatti              Mathematics       Complex Analysis                 6.60
            124 Hemachandra Bhatnagar      Mathematics       Complex Analysis                 5.50
            156 Kumari Karnik              Mathematics       Complex Analysis                 4.00
            106 Anand Jha                  Mathematics       Complex Analysis                 3.00
            139 Krishnaraja Anand          Mathematics       Complex Analysis                 2.90

(7 rows affected)
```

#### 4. NULL Values

``` sql
1> SELECT *
2> FROM students
3> WHERE dob IS NULL;
4> GO
reg_no first_name    last_name    age      standard    division phone        dob
------ ------------- ------------ -------- ----------- -------- ------------ ----------------
   101 Jyoti         Chauhan            13           8 C        7977740188               NULL
   102 Arjun         Pillai             11           6 C        9205915713               NULL
   103 Kevala        Yohannan           11           6 B        7637159799               NULL
   104 Damayandi     Pal                13           8 A        6204606448               NULL
   105 Nandini       Mann               15          10 C        6955348575               NULL
   106 Anand         Jha                15          10 A        7349914564               NULL
   ... ...           ...               ...           ...               ...                ...

(80 rows affected)
```

#### 5. NULL functions

* ISNULL()

``` sql
1> SELECT
2> reg_no,
3> CONCAT(first_name, ' ', last_name) as Student_Name,
4> ISNULL('UNKNOWN', dob) as dob
5> FROM students;
6> GO
reg_no Student_Name        dob
------ ------------------- -------
   101 Jyoti Chauhan       UNKNOWN
   102 Arjun Pillai        UNKNOWN
   103 Kevala Yohannan     UNKNOWN
   104 Damayandi Pal       UNKNOWN
   105 Nandini Mann        UNKNOWN
   106 Anand Jha           UNKNOWN
   107 Chandana Bose       UNKNOWN
   108 Carliaye Sahota     UNKNOWN
   ... ...                 ...

(80 rows affected)
```

* COALESCE()

``` sql
1> SELECT
2> reg_no,
3> CONCAT(first_name, ' ', last_name) as Student_Name,
4> COALESCE(DATEADD(YEAR, -age, CAST(GETDATE() AS DATE)), dob) as dob
5> FROM students;
6> GO
reg_no Student_Name        dob
------ ------------------- ----------------
   101 Jyoti Chauhan             2010-12-30
   102 Arjun Pillai              2012-12-30
   103 Kevala Yohannan           2012-12-30
   104 Damayandi Pal             2010-12-30
   105 Nandini Mann              2008-12-30
   106 Anand Jha                 2008-12-30
   107 Chandana Bose             2009-12-30
   108 Carliaye Sahota           2012-12-30
   ... ...                       ...

(80 rows affected)
```

* NULLIF()

``` sql
1> SELECT
2> NULLIF(10, 10);
3> GO

---
NUL

(1 rows affected)
1> SELECT
2> NULLIF(10, 20);
3> GO

---
 10

(1 rows affected)
```

### Stored Procedures

* A procedure to calculate percentage from student roll number

``` sql
1> CREATE PROCEDURE percentage(@roll_no AS SMALLINT, @out_of AS SMALLINT = 10)
2> AS
3> SELECT
4> s.reg_no AS Student_Roll_No,
5> CONCAT(s.first_name, ' ', s.last_name) AS Student_Name,
6>      (CASE WHEN (SUM(ar.marks_obt)/COUNT(ar.marks_obt))*@out_of > 0
7>                THEN (SUM(ar.marks_obt)/COUNT(ar.marks_obt))*@out_of
8>                ELSE 'No assignment submitted'
9>                END) AS Percentage
10> FROM
11> students AS s INNER JOIN assignment_results AS ar
12> ON s.reg_no = ar.student_id
13> INNER JOIN classes AS c
14> ON c.id = ar.class_id
15> INNER JOIN assignments as a
16> ON a.id = ar.assignment_id
17> WHERE s.reg_no = @roll_no
18> GROUP BY s.reg_no, CONCAT(s.first_name, ' ', s.last_name);
19> GO
1> EXEC percentage @roll_no = 135;
2> GO
Student_Roll_No Student_Name      Percentage
--------------- ----------------- ----------------
            135 Jayanta Parikh           78.500000

(1 rows affected)
```

* A procedure to calculate grade from student roll number

``` sql
1> CREATE PROCEDURE student_grade(
2>      @roll_no AS SMALLINT,
3>      @out_of AS SMALLINT = 10,
4>      @grade AS VARCHAR(23) OUTPUT
5> )
6> AS
7> BEGIN
8> DECLARE @percentage AS SMALLINT
9>
10> SELECT
11>     @percentage =
12>               (CASE WHEN (SUM(ar.marks_obt)/COUNT(ar.marks_obt))*@out_of > 0
13>               THEN (SUM(ar.marks_obt)/COUNT(ar.marks_obt))*@out_of
14>               ELSE -1
15>               END)
16> FROM assignment_results as ar
17> WHERE student_id = @roll_no;
18>
19> IF @percentage = -1
20>     BEGIN
21>             SELECT 'No assignment submitted'
22>     END
23> ELSE
24>     IF @percentage > 90
25>             SET @grade = 'A'
26>     ELSE IF @percentage > 80
27>             SET @grade = 'B'
28>     ELSE IF @percentage > 70
29>             SET @grade = 'C'
30>     ELSE IF @percentage > 60
31>             SET @grade = 'D'
32>     ELSE IF @percentage > 50
33>             SET @grade = 'E'
34>     ELSE
35>             SET @grade = 'F'
36>
37> END;
38> GO
1> DECLARE @result VARCHAR(1)
2> EXEC student_grade @roll_no = 135, @grade = @result OUTPUT
3> SELECT @result AS 'Grade';
4> GO
Grade
-----
C

(1 rows affected)
1> DECLARE @result VARCHAR(1)
2> EXEC student_grade @roll_no = 110, @grade = @result OUTPUT
3> SELECT @result AS 'Grade';
4> GO

-----------------------
No assignment submitted

(1 rows affected)
Grade
-----
NULL

(1 rows affected)
```
