package database_handlers;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 */
public class CreateSQL {

	public static boolean createTable(Connection connection) {
		
		try {
			
			Statement statement = connection.createStatement();
			
			String createQuery;
			
//			createQuery = "DROP TABLE Persons";
			
			createQuery = "CREATE TABLE Persons (" +
								"id INT NOT NULL IDENTITY(1,1) PRIMARY KEY, " +
								"prefix VARCHAR(4) NOT NULL, " + 
								"first_name VARCHAR(255) NOT NULL, " + 
								"middle_name VARCHAR(255), " + 
								"last_name VARCHAR(255) NOT NULL, " +
								"username VARCHAR(255) UNIQUE NOT NULL, " +
								"email VARCHAR(255) UNIQUE, " +
								"password VARCHAR(255) NOT NULL, " +
								"birthdate DATE NOT NULL, " +
								"age TINYINT NOT NULL, " +
								"gender VARCHAR(6) NOT NULL" +
								");"; 
			
			statement.executeUpdate(createQuery);
			return true;	
		} 
		catch (SQLException sqle) {
			sqle.printStackTrace();
			return false;
		}	
	}
	
	public static void main(String[] args) {
		createTable(ConnectionSQLServer.getServerConnection());
	}
}
