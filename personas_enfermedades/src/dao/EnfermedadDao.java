package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import pojo.Persona;
import pojo.Enfermedad;
import util.DataBaseConnection;


public class EnfermedadDao extends ObjetoDao  implements InterfazDao<Enfermedad> {
	
	private static Connection connection;
	
	public EnfermedadDao () {
		
	}

	


	@Override
	public Enfermedad buscarPorId(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertar(Enfermedad eF) {
		// TODO Auto-generated method stub
		connection = openConnection();
		
		String query = "insert into enfermedades (dias_curacion, nombre," 
				 + "persona_id) values (?, ?, ?)";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, eF.getDias_curacion());
			ps.setString(2, eF.getNombre());
			ps.setInt(3, eF.getPersona().getId()); 
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		closeConnection();
	}

	@Override
	public void modificar(Enfermedad enfermedad) {
		// TODO Auto-generated method stub
		
connection = openConnection();
		
		int id= enfermedad.getId();
		int dias_curacion= enfermedad.getDias_curacion();
		String nombre = enfermedad.getNombre();
		Persona persona= enfermedad.getPersona();
		String nombre_per = persona.getNombre();
		
		String query = "update enfermedades set nombre = ?, edad = ?, "
				+ "apellidos = ? where id = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1,id );
			ps.setInt(2, dias_curacion);
			ps.setString(3, nombre);
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		closeConnection();
		
	}
		
	

	@Override
	public void borrar(Enfermedad e) {
		// TODO Auto-generated method stub
		
		 connection = openConnection();
		 
		 int id=e.getId();
	        String query = "DELETE FROM enfermedades where id=?;";
	        try {
	            PreparedStatement ps = connection.prepareStatement(query);
	            ps.setInt(1, e.getId());
	            ps.executeUpdate();
	        } catch (SQLException e1) {
	            // TODO Auto-generated catch block
	            e1.printStackTrace();
	        }

	        closeConnection();
		
	}
	
	protected static Connection openConnection() {
		DataBaseConnection dbConnection = new DataBaseConnection();
		connection = dbConnection.getConnection();
		return connection;
	}
	
	protected static void closeConnection() {
		try {
			connection.close();
			connection = null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}




	@Override
	public ArrayList<Enfermedad> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}
	public void borrarPorpersona (int persona_id) {
		
		connection = openConnection();
		String quuery="DELETE FROM temporadas WHERE persona_id=?";
		try {
			PreparedStatement ps= connection.prepareStatement(quuery);
			ps.setInt(1, persona_id);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	
		 closeConnection();

	}
	
}