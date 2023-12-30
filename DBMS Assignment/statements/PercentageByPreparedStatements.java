package statements;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import jdbc_ms_sqlserver.ConnectionSQLServer;

public class PercentageByPreparedStatements {

	public static void main(String[] args) {
		
		Connection connection = ConnectionSQLServer.getServerConnection();
		PreparedStatement statement = null;
		
		System.out.print("Enter the student reg_no: ");
		Scanner scanner = new Scanner(System.in);
		
		try {
			
			int reg_no = scanner.nextInt();
			statement = connection.prepareStatement("USE assignment; EXEC percentage ?;");
			statement.setInt(1, reg_no);

			ResultSet resultSet = statement.executeQuery();
			
			if(resultSet.next()) {
				System.out.println("\n" + "reg_no: " + resultSet.getString(1) + "\nname: " + resultSet.getString(2) + "\npercentage: " + resultSet.getString(3));
			} 
			else {
				System.out.println("\nNo assignment submitted.");
			}			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally{
			try {
				statement.close();
				connection.close();
				scanner.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
