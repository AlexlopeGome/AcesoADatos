package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConnection {

Connection connection;	

public Connection getConnection() {
	String dbName= "bd_zoologico";
	String userName= "root";
	String password= "capi1984";
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		connection= DriverManager.getConnection(
				"jdbc:mysql://localhost/"+dbName,
				userName,
				password);
	} catch ( Exception e) {
		// TODO: handle exception
	}
	
	return connection;
	
}
}
