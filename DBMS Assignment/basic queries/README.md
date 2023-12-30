## Basic Queries

1. [DISTINCT](#distinct)
2. [WHERE](#where)
3. [AND](#and)
4. [OR](#or)
5. [IN](#in)
6. [BETWEEN](#between)
7. [ORDER BY](#order-by)
8. [GROUP BY and HAVING](#group-by-and-having)
9. [SELECT TOP](#select-top)
10. [LIKE, Wildcards and Aliases](#like-wildcards-and-aliases)


### DISTINCT

``` sql
1> SELECT APPROX_COUNT_DISTINCT(student_id) as Number_of_students
2> FROM assignment_results;
3> GO
Number_of_students
--------------------
                  30

(1 rows affected)
```

### WHERE

``` sql
1> SELECT
2> CONCAT(s.first_name, ' ', s.last_name) as Student_Name,
3> marks_obt
4> FROM
5> students as s INNER JOIN assignment_results as ar
6> ON s.reg_no = ar.student_id
7> WHERE marks_obt > 7;
8> GO
Student_Name                   marks_obt
------------------------------ ---------
Mahesh Raghavan                8.50
Anjali Bail                    8.40
Anjali Bail                    9.50
Jayanta Parikh                 9.70
Nanda Rajagopalan              9.30
Jayant Venkatesh               8.40
Kanda-Koumarane Thaker         7.20
...                            ...

(22 rows affected)
```

### AND

``` sql
1> SELECT
2> CONCAT(s.first_name, ' ', s.last_name) as Student_Name,
3> c.name as Class_Name,
4> ar.marks_obt as Marks_Obtained
5> FROM
6> students AS s INNER JOIN assignment_results AS ar
7> ON s.reg_no = ar.student_id
8> INNER JOIN classes AS c
9> ON c.id = ar.class_id
10> WHERE ar.marks_obt > 5 AND c.name = 'Mathematics';
11> GO
Student_Name                 Class_Name     Marks_Obtained
---------------------------- -------------- --------------
Jayanta Parikh               Mathematics              9.60
Kumari Karnik                Mathematics              6.60
Hemachandra Bhatnagar        Mathematics              5.70
Krishnaraja Anand            Mathematics              9.70
Jayanta Parikh               Mathematics              6.80
Manu Keer                    Mathematics              9.70
Hemachandra Bhatnagar        Mathematics              5.50
Jarita Bhatti                Mathematics              6.60

(8 rows affected)
```

### OR

``` sql
1> SELECT
2> CONCAT(s.first_name, ' ', s.last_name) as Student_Name,
3> c.name as Class_Name,
4> c.type as Class_Type,
5> ar.marks_obt as Marks_Obtained
6> FROM
7> students AS s INNER JOIN assignment_results AS ar
8> ON s.reg_no = ar.student_id
9> INNER JOIN classes AS c
10> ON c.id = ar.class_id
11> WHERE c.name = 'Physics' AND c.type = 'Theory' OR c.name = 'Chemistry' AND c.type = 'Theory';
12> GO
Student_Name           Class_Name     Class_Type     Marks_Obtained
---------------------- -------------- -------------- --------------
Govinden Kashyap       Physics        Theory                   2.20
Dharmaradj Varkey      Physics        Theory                   2.50
Nilam Salvi            Physics        Theory                   8.70
Carliaye Sahota        Physics        Theory                   8.30
Jagjit Ray             Physics        Theory                   8.10
Akhil Palla            Physics        Theory                   4.00
Dharmaradj Varkey      Physics        Theory                   5.90
...                    ...            ...                      ...

(22 rows affected)
```

### IN

``` sql
2> CONCAT(s.first_name, ' ', s.last_name) as Student_Name,
3> c.name as Class_Name,
4> c.type as Class_Type,
5> ar.marks_obt as Marks_Obtained
6> FROM
7> students AS s INNER JOIN assignment_results AS ar
8> ON s.reg_no = ar.student_id
9> INNER JOIN classes AS c
10> ON c.id = ar.class_id
11> WHERE c.name IN ('Physics', 'Chemistry', 'Biology');
12> GO
Student_Name                Class_Name   Class_Type      Marks_Obtained
--------------------------- ------------ --------------- --------------
Govinden Kashyap            Physics      Theory                    2.20
Dharmaradj Varkey           Physics      Theory                    2.50
Nilam Salvi                 Physics      Theory                    8.70
Carliaye Sahota             Physics      Theory                    8.30
Jagjit Ray                  Physics      Theory                    8.10
Akhil Palla                 Physics      Theory                    4.00
Dharmaradj Varkey           Physics      Theory                    5.90
Dhaval Bora                 Physics      Theory                    9.60
Arjun Pillai                Physics      Theory                    5.80
...                         ...          ...                       ...

(28 rows affected)
```

### BETWEEN

``` sql
1> SELECT
2> CONCAT(s.first_name, ' ', s.last_name) as Student_Name,
3> c.name as Class_Name,
4> ar.marks_obt as Marks_Obtained
5> FROM
6> students AS s INNER JOIN assignment_results AS ar
7> ON s.reg_no = ar.student_id
8> INNER JOIN classes AS c
9> ON c.id = ar.class_id
10> WHERE ar.marks_obt BETWEEN 5 AND 7;
11> GO
Student_Name                   Class_Name             Marks_Obtained
------------------------------ ---------------------- --------------
Jayanta Parikh                 English Literature               5.30
Devi Kannan                    English Literature               6.10
Devi Kannan                    English Literature               6.10
Nandini Mann                   English Literature               6.40
Jayant Venkatesh               English Language                 6.90
Kanda-Koumarane Thaker         English Language                 5.10
Narayanin Sekhon               Hindi                            5.80
...                            ....                             ...

(25 rows affected)
```

### ORDER BY

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
13> ON a.id = ar.assignment_id
14> WHERE ar.marks_obt BETWEEN 5 AND 7
15> ORDER BY ar.marks_obt, s.reg_no, c.name;
16> GO
Student_Roll_No Student_Name                 Class_Name              Assignment_Name          Marks_Obtained
--------------- ---------------------------- ----------------------- ------------------------ --------------
            126 Chandana Pillay              Biology                 Photosynthesis                     5.10
            154 Kanda-Koumarane Thaker       English Language        Verbs                              5.10
            111 Chandraradj Halder           Biology                 Photosynthesis                     5.20
            107 Chandana Bose                History                 European Renaissance               5.30
            135 Jayanta Parikh               English Literature      Poem Rhyming Scheme                5.30
            150 Indrani Dey                  History                 European Renaissance               5.40
            124 Hemachandra Bhatnagar        Mathematics             Complex Analysis                   5.50
            ... ...                          ...                     ...                                ...

(25 rows affected)
```

### GROUP BY and HAVING

``` sql
1> SELECT
2> s.reg_no as Student_Roll_No,
3> CONCAT(s.first_name, ' ', s.last_name) as Student_Name,
4> SUM(ar.marks_obt) as Marks_Obtained
5> FROM
6> students AS s INNER JOIN assignment_results AS ar
7> ON s.reg_no = ar.student_id
8> INNER JOIN classes AS c
9> ON c.id = ar.class_id
10> INNER JOIN assignments as a
11> ON a.id = ar.assignment_id
12> GROUP BY CONCAT(s.first_name, ' ', s.last_name), s.reg_no
13> HAVING SUM(ar.marks_obt) > 15;
14> GO
Student_Roll_No Student_Name          Marks_Obtained
--------------- --------------------- -----------------
            107 Chandana Bose                     21.40
            108 Carliaye Sahota                   15.10
            114 Jagjit Ray                        16.50
            119 Jayant Venkatesh                  24.50
            135 Jayanta Parikh                    31.40
            138 Manu Keer                         31.90
            147 Anjali Bail                       24.50
            165 Dharmaradj Varkey                 18.70
            179 Dhaval Bora                       16.20

(9 rows affected)
```

### SELECT TOP

``` sql
1> SELECT TOP 10
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
13> ON a.id = ar.assignment_id
14> ORDER BY ar.marks_obt DESC, s.reg_no ASC;
15> GO
Student_Roll_No Student_Name              Class_Name             Assignment_Name                    Marks_Obtained
--------------- ------------------------- ---------------------- ---------------------------------- --------------
            135 Jayanta Parikh            English Literature     Lesson 1 Hard Words                          9.70
            138 Manu Keer                 Mathematics            Complex Analysis                             9.70
            139 Krishnaraja Anand         Mathematics            Pythagora's Theorem                          9.70
            135 Jayanta Parikh            Mathematics            Pythagora's Theorem                          9.60
            179 Dhaval Bora               Physics                Acceleration of a Falling Body               9.60
            147 Anjali Bail               English Literature     Lesson 1 Hard Words                          9.50
            122 Nanda Rajagopalan         English Literature     Lesson 1 Hard Words                          9.30
            138 Manu Keer                 Hindi                  लेखक परिचय                                   9.30
            143 Anima Radhakrishnan       English Language       Verbs                                        9.20
            107 Chandana Bose             Biology                Photosynthesis                               9.10

(10 rows affected)
```

### LIKE, Wildcards and Aliases

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
13> ON a.id = ar.assignment_id
14> WHERE CONCAT(s.first_name, ' ', s.last_name) LIKE 'An%'
15> ORDER BY Student_Name;
16> GO
Student_Roll_No Student_Name             Class_Name              Assignment_Name          Marks_Obtained
--------------- ------------------------ ----------------------- ------------------------ --------------
            106 Anand Jha                Mathematics             Pythagoras Theorem                4.40
            106 Anand Jha                Mathematics             Complex Analysis                   3.00
            143 Anima Radhakrishnan      English Language        Adjectives                         2.30
            143 Anima Radhakrishnan      English Language        Verbs                              9.20
            147 Anjali Bail              History                 Opium War                          2.20
            147 Anjali Bail              History                 European Renaissance               4.40
            147 Anjali Bail              English Literature      Poem Rhyming Scheme                8.40
            147 Anjali Bail              English Literature      Lesson 1 Hard Words                9.50

(8 rows affected)
```
