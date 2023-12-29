package database_handlers;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;

/**
 * 
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Connection connection = ConnectionSQLServer.getServerConnection();
		
//		if(CreateSQL.createTable(connection)) {
//			System.out.println("Table successfully created.");
//		}
//		else { 
//			System.out.println("Table not Created.");
//		}

		
//		SelectTable.selectQuery(connection);
		
		Person person = null;
		
		try {
			person = new Person();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
//		InsertIntoTable.insertIntoPersons(connection, person);
		SelectTable.selectQuery(connection);
	}
}
