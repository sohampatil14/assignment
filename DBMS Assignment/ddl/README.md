## DDL Commands

1. [CREATE](#create---createsql)
2. [ALTER](#alter)
    
    * [ALTER TABLE ADD COLUMN](#1-alter-table-add-column)
    * [ALTER TABLE DROP COLUMN](#2-alter-table-drop-column)
    * [ALTER TABLE RENAME COLUMN NAME](#3-alter-table-rename-column-name)
    * [ALTER TABLE DROP CONSTRAINT](#4-alter-table-drop-constraint)
    * [ALTER TABLE ADD CONTRAINT](#5-alter-table-add-constraint)
    * [ALTER TABLE ADD CONSTRAINT](#5-alter-table-add-constraint)

3. [TRUNCATE](#truncate)
4. [DROP](#drop)

### CREATE - [create.sql](./create.sql)

``` sql
1> CREATE TABLE temp_table1 (
2> id SMALLINT PRIMARY KEY,
3> val VARCHAR(30)
4> );
5>
6> CREATE TABLE temp_table2 (
7> id SMALLINT PRIMARY KEY,
8> val VARCHAR(30)
9> );
10>
11> INSERT INTO temp_table1
12> VALUES (1, 'Aarav Gupta'),
13>        (2, 'Nisha Patel'),
14>        (3, 'Rahul Sharma'),
15>        (5, 'Priya Singhania');
16>
17>
18> INSERT INTO temp_table2
19> VALUES (1, 'Arjun Kapoor'),
20>        (2, 'Meera Chatterjee'),
21>        (4, 'Rohan Desai'),
22>        (5, 'Sanya Verma');
23> go

(4 rows affected)

(4 rows affected)
```

### ALTER

#### 1. ALTER TABLE ADD COLUMN

``` sql
1> ALTER TABLE temp_table1
2> ADD val2 VARCHAR(10);
3>
4> SELECT * FROM temp_table1;
5> GO
id     val                            val2
------ ------------------------------ ----------
     1 Aarav Gupta                    NULL
     2 Nisha Patel                    NULL
     3 Rahul Sharma                   NULL
     5 Priya Singhania                NULL

(4 rows affected)
```

#### 2. ALTER TABLE DROP COLUMN

``` sql
1> ALTER TABLE temp_table1
2> DROP COLUMN val2;
3>
4> SELECT * FROM temp_table1;
5> GO
id     val
------ ------------------------------
     1 Aarav Gupta
     2 Nisha Patel
     3 Rahul Sharma
     5 Priya Singhania

(4 rows affected)
```

#### 3. ALTER TABLE RENAME COLUMN NAME

``` sql
1> EXEC sp_rename 'temp_table1.val', 'val1', 'COLUMN';
2>
3> SELECT * FROM temp_table1;
4> GO
Caution: Changing any part of an object name could break scripts and stored procedures.
id     val1
------ ------------------------------
     1 Aarav Gupta
     2 Nisha Patel
     3 Rahul Sharma
     5 Priya Singhania

(4 rows affected)
```

#### 4. ALTER TABLE DROP CONSTRAINT

``` sql
1> SELECT name
2> FROM sys.key_constraints
3> WHERE type = 'PK' AND OBJECT_NAME(parent_object_id) = N'temp_table1';
4> GO
name
---------------------------------
PK__temp_tab__3213E83FD4765398

(1 rows affected)
1> ALTER TABLE temp_table1
2> DROP CONSTRAINT PK__temp_tab__3213E83FD4765398;
3> GO
```

#### 5. ALTER TABLE ADD CONSTRAINT

``` sql
1> ALTER TABLE temp_table1
2> ALTER COLUMN id SMALLINT NOT NULL;
3> GO
1> ALTER TABLE temp_table1
2> ADD CONSTRAINT PK_id PRIMARY KEY(id);
3> GO
1> SELECT name
2> FROM sys.key_constraints
3> WHERE type = 'PK' AND OBJECT_NAME(parent_object_id) = N'temp_table1';
4> GO
name
--------------------------------
PK_id

(1 rows affected)
```

#### 6. ALTER TABLE ALTER COLUMN DATATYPE

``` sql
1> ALTER TABLE temp_table1
2> ALTER COLUMN id DECIMAL(4, 2);
3>
4> SELECT * FROM temp_table1;
5> GO
id     val1
------ ------------------------------
  1.00 Aarav Gupta
  2.00 Nisha Patel
  3.00 Rahul Sharma
  5.00 Priya Singhania

(4 rows affected)
```

### TRUNCATE

``` sql
1> SELECT * FROM temp_table1;
2> SELECT * FROM temp_table2;
3> GO
id     val
------ ------------------------------
     1 Aarav Gupta
     2 Nisha Patel
     3 Rahul Sharma
     5 Priya Singhania

(4 rows affected)
id     val
------ ------------------------------
     1 Arjun Kapoor
     2 Meera Chatterjee
     4 Rohan Desai
     5 Sanya Verma

(4 rows affected)
1> TRUNCATE TABLE temp_table1;
2> TRUNCATE TABLE temp_table2;
3>
4> SELECT * FROM temp_table1;
5> SELECT * FROM temp_table2;
6> GO
id     val
------ ------------------------------

(0 rows affected)
id     val
------ ------------------------------

(0 rows affected)
```

### DROP

``` sql
1> DROP TABLE temp_table1;
2> DROP TABLE temp_table2;
3> GO
1> SELECT * FROM temp_table1;
2> SELECT * FROM temp_table2;
3> GO

Msg 208, Level 16, State 1, Server LAPTOP-77PHDL97, Line 1
Invalid object name 'temp_table1'.
```