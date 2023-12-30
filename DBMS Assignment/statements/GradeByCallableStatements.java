package statements;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import jdbc_ms_sqlserver.ConnectionSQLServer;

public class GradeByCallableStatements {

	public static void main(String[] args) {

		Connection connection = ConnectionSQLServer.getServerConnection();
		CallableStatement statement = null;
		
		System.out.print("Enter the student reg_no: ");
		Scanner scanner = new Scanner(System.in);
		
		String queryString = "USE assignment; EXEC student_grade @roll_no = ?, @grade = ?;";
		
		try {
			
			int reg_no = scanner.nextInt();
			statement = connection.prepareCall(queryString);
			
			statement.setInt(1, reg_no);
			statement.registerOutParameter(2, java.sql.Types.VARCHAR);
			
			statement.executeUpdate();
			
			if(statement.getString(2).equals("-1")) {
				System.out.println("\nNo assignment submitted.");
			} 
			else {
				System.out.println("\n" + "reg_no: " + reg_no + "\ngrade: " + statement.getString(2));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
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
