package database_handlers;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertIntoTable {

	public static boolean insertIntoPersons(Connection connection, Person person) {
		
		try {
			
			Statement statement = connection.createStatement();
			String insertQueryString = String.format("INSERT INTO Persons " + 
										"(prefix, first_name, middle_name, last_name, " +
										"username, email, password, birthdate, age, gender)" +
										" VALUES (" +
										"\'%s\', \'%s\', \'%s\', \'%s\', " +
										"\'%s\', \'%s\', \'%s\', \'%s\', " +
										"\'%d\', \'%s\');", 
										person.prefix, person.firstName, person.middleName, person.lastName,
										person.username, person.email, person.password, person.dateOfBirth.toString(),
										person.age, person.gender
										);
			statement.executeUpdate(insertQueryString);
			return true;
		} 
		catch (SQLException e) {
			return false;
		}
	}
	
	public static void main(String[] args) {
		try {
			System.out.println(insertIntoPersons(ConnectionSQLServer.getServerConnection(), new Person()));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
