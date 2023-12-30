## DML Commands

1. [INSERT](#insert)
2. [UPDATE](#update)
3. [DELETE](#delete)

### INSERT

* [INSERT INTO students](./insert_students.sql)
* [INSERT INTO teachers](./insert_teachers.sql)
* [INSERT INTO classes](./insert_classes.sql)
* [INSERT INTO assignment](./insert_assignment.sql)
* [INSERT INTO class_by_students](./insert_class_by_students.sql)
* [INSERT INTO class_by_teachers](./insert_class_by_teachers.sql)
* [INSERT INTO assignment_results](./insert_assignment_results.sql)

### UPDATE

``` sql
1> SELECT * FROM temp_table2;
2> GO
id     val
------ ------------------------------
     1 Arjun Kapoor
     2 Meera Chatterjee
     4 Rohan Desai
     5 Sanya Verma

(4 rows affected)
1>
2> UPDATE temp_table2
3> SET val = 'Arjun Rajput'
4> WHERE id = 1;
5>
6> SELECT * FROM temp_table2;
7> GO

(1 rows affected)
id     val
------ ------------------------------
     1 Arjun Rajput
     2 Meera Chatterjee
     4 Rohan Desai
     5 Sanya Verma

(4 rows affected)
```

### DELETE

``` sql
1> SELECT * FROM temp_table1;
2> GO
id     val
------ ------------------------------
     1 Aarav Gupta
     2 Nisha Patel
     3 Rahul Sharma
     5 Priya Singhania

(4 rows affected)
1>
2> DELETE FROM temp_table1
3> WHERE id = 1;
4>
5> SELECT * FROM temp_table1;
6> GO

(1 rows affected)
id     val
------ ------------------------------
     2 Nisha Patel
     3 Rahul Sharma
     5 Priya Singhania

(3 rows affected)
```