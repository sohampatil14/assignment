package database_handlers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
	
public class ConnectionSQLServer {

	public static Connection getServerConnection() {
		
		String connectionUrl =
                "jdbc:sqlserver://localhost:49172;"
                        + "database=servlet_login_application;"
                        + "user=su;"
                        + "password=soham@14;"
                        + "encrypt=false;"
                        + "trustServerCertificate=false;"
                        + "loginTimeout=30;";

		Connection connection = null;
        try {
        	connection = DriverManager.getConnection(connectionUrl); 
        	System.out.println("Connection Successful");
        }
        catch (SQLException sqle) {
			sqle.printStackTrace();
		}
        
		return connection;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		getServerConnection();
		System.exit(0);
		
		String connectionUrl =
                "jdbc:sqlserver://localhost:49172;"
                        + "database=servlet_login_application;"
                        + "user=su;"
                        + "password=soham@14;"
                        + "encrypt=false;"
                        + "trustServerCertificate=false;"
                        + "loginTimeout=30;";

        try (Connection connection = DriverManager.getConnection(connectionUrl);) {
            
        	System.out.println("Connection Successful");
            
        	String queryString = "SELECT * FROM Persons;";
        	Statement statement = connection.createStatement();
        	ResultSet resultSet = statement.executeQuery(queryString);

            // Print results from select statement
            while (resultSet.next()) {
            	System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2)); //.getString() + " " + resultSet.getString(0));
            }
        	
        	
//        	String queryString = "INSERT INTO dbo.temp VALUES (1,100);";
//            ResultSet resultSet = null;
//            
//            PreparedStatement prepsInsertProduct = connection.prepareStatement(queryString, Statement.RETURN_GENERATED_KEYS);
//            prepsInsertProduct.execute();
//            resultSet = prepsInsertProduct.getGeneratedKeys();
//            
//            // Print the ID of the inserted row.
//            while (resultSet.next()) {
//            	System.out.println("Generated: " + resultSet.getString(1));
//            }
            
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }
	}

}

