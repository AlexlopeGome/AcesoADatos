package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;


import pojo.Serie;
import util.DataBaseConnection;

public class SerieDao  implements Dao<Serie>{
private static Connection connection;


public void SerieDao() {
	
}

	


public Connection getConnection() {
	
	String dbName= "bd_series";
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

private static Connection  openConnection() {
	
	DataBaseConnection dbConnection = new DataBaseConnection();
	connection =dbConnection.getConnection();
	return connection;
}

private  static void closeConnection() {
	
	try {
		connection.close();
		connection=null;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	@Override
	public ArrayList<Serie> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Serie buscarPorId(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertar(Serie serie) {
		connection= openConnection();
		
		String query= "insert into series (titulo,edad,plataforma)"
				+"values(?,?,?)";
		try {
			PreparedStatement ps= connection.prepareStatement(query);
			ps.setString(1, serie.getTitulo());
			ps.setInt(2, serie.getEdad());
			ps.setString(3, serie.getPlataforma());
			ps.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void modificar(Serie t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void borrar(Serie t) {
		// TODO Auto-generated method stub
		
	}

}
