package jdbc_ms_sqlserver;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Connection connection = ConnectionSQLServer.getServerConnection();
		
		if(CreateSQL.createTable(connection)) {
			System.out.println("Table successfully created.");
		}
		else { 
			System.out.println("Table not Created.");
		}

		
//		SelectTable.selectQuery(connection);
		
		Person person = null;
		
		try {
			person = new Person();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		if(InsertIntoTable.insertIntoPersons(connection, person)) {
			System.out.println("Default Person object insertion successful.");
		}
		else { 
			System.out.println("Insertion unsuccessful.");
		}
		SelectTable.selectQuery(connection);
	}
}
