package database_handlers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginRecordCheck {

	public static int checkRecords(Connection connection, String username, String password) {
		
		String queryString = String.format("SELECT username, password FROM PERSONS WHERE username=\'%s\' AND password=\'%s\';", username, password);
		Statement statement = null;
		
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(queryString);
			if(!resultSet.next()) {
				System.out.println(resultSet.next());
				System.out.println("No Record");
				return -1;
			}
			System.out.println("Record Exists");
			return 0;
		}
		catch (SQLException e) {
			e.printStackTrace();
			return -2;
		}
	}
}
