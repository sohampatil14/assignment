### Microsoft SQL Server JDBC Driver

Files -

1. [ConnectionSQLServer.java](./src/main/java/jdbc_ms_sqlserver/ConnectionSQLServer.java): provides a static method getServerConnection() which returns a java.sql.Connection object
2. [CreateSQL.java](./src/main/java/jdbc_ms_sqlserver/CreateSQL.java): has a static method createTable(Connection) which creates a Person table and returns boolean variable based on success
3. [InsertIntoTable.java](./src/main/java/jdbc_ms_sqlserver/InsertIntoTable.java): has a static method insertIntoPersons(Connection, Person) which inserts into table Person and returns boolean variable based on success
4. [SelectTable.java](./src/main/java/jdbc_ms_sqlserver/SelectTable.java): has a static method selectQuery(Connection) which prints all the records in the Person table
5. [Main.java](./src/main/java/jdbc_ms_sqlserver/Main.java): drive code to execute the methods in above files

Output after executing Main.java -

```
Table successfully created.
Default Person object insertion successful.
ID: 1, Name: Person Pearson Pearson, Username: person, HPassword: 008a8d9229013e0c75a718ee6e509d8734159dad174e643dda6d6fe8b9a9b760, Email: person@mail.com, Birthdate: 2002-01-01, Age: 21, Gender: Male
```