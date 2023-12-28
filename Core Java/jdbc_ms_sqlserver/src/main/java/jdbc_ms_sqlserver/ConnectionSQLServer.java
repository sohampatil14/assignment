package jdbc_ms_sqlserver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
	
public class ConnectionSQLServer {

	public static Connection getServerConnection() {
		
		String connectionUrl = "jdbc:sqlserver://localhost:49172;"
                        + "database=servlet_login_application;"
                        + "user=su;"
                        + "password=soham@14;"
                        + "encrypt=false;"
                        + "trustServerCertificate=false;"
                        + "loginTimeout=30;";
		
		Connection connection = null;
		
        try {
        	connection = DriverManager.getConnection(connectionUrl);
        }
        catch (SQLException sqle) {
			sqle.printStackTrace();
		}
        
		return connection;
	}
}

