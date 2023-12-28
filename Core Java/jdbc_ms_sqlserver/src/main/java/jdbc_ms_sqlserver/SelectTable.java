package jdbc_ms_sqlserver;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class SelectTable {
	
	public static void selectQuery(Connection connection) {
		String queryString = "SELECT * FROM Persons;";
    	Statement statement = null;

    	try {
		
    		statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(queryString);
			while(resultSet.next()) {
				System.out.println(
						String.format(
								"ID: %d, Name: %s %s %s, Username: %s, HPassword: %s, " +
								"Email: %s, Birthdate: %s, Age: %d, Gender: %s", 
								resultSet.getInt("id"), resultSet.getString("first_name"), resultSet.getString("middle_name"), 
								resultSet.getString("last_name"), resultSet.getString("username"), resultSet.getString("password"),
								resultSet.getString("email"), resultSet.getString("birthdate"), resultSet.getInt("age"), 
								resultSet.getString("gender"))
						);
			}
		} 
    	catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
