package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import pojo.Persona;
import util.DataBaseConnection;

public class ObjetoDao {
	protected static Connection connection;
	
	
	protected static Connection  openConnection() {
		
		DataBaseConnection dbConnection = new DataBaseConnection();
		connection =dbConnection.getConnection();
		return connection;
	}

	protected static void closeConnection() {
		
		try {
			connection.close();
			connection=null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void borrarTablas() {
		connection = openConnection();
		String query = "DROP TABLE enfermedades;";
		try {
			PreparedStatement ps = connection.prepareStatement(query);

			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String query2 = "DROP TABLE personas;";
		try {
			PreparedStatement ps = connection.prepareStatement(query2);

			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		closeConnection();
	}

	public void crearTablas() {
		connection = openConnection();
		String query = "create table personas(\r\n"
				+ "	id INT PRIMARY KEY AUTO_INCREMENT,\r\n"
				+ "    nombre VARCHAR(40),\r\n"
				+ "    apellidoUno VARCHAR(20),\r\n"
				+ "    apellidoDos VARCHAR(20),\r\n"
				+ "    edad INT\r\n"
				+ ");";
		try {
			PreparedStatement ps = connection.prepareStatement(query);

			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String query2 = "create table enfermedades(\r\n"
				+ "id INT PRIMARY KEY AUTO_INCREMENT,\r\n"
				+ "dias_curacion INT NOT NULL,\r\n"
				+ "nombre VARCHAR(100) NOT NULL,\r\n"
				+ "persona_id INT NOT NULL,\r\n"
				+ "CONSTRAINT fk_enfermedad_persona\r\n"
				+ "	FOREIGN KEY(persona_id)\r\n"
				+ "    REFERENCES personas(id)\r\n"
				+ ");";
		try {
			PreparedStatement ps = connection.prepareStatement(query2);

			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		closeConnection();
	}

}
