package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pojo.Enfermedad;
import pojo.Persona;
import util.DataBaseConnection;


public class EnfermedadDao  extends ObjetoDao implements InterfazDao<Enfermedad> {

	@Override
	public ArrayList<Enfermedad> buscarTodos() {
		connection=openConnection();
		ArrayList<Enfermedad> enfermedades=new ArrayList<Enfermedad>();
		String query="select * from enfermedades";
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			
			while (rs.next()) {
				Enfermedad enfermedad = new Enfermedad(
						rs.getInt("id"),
						rs.getString("nombre"),
						rs.getString("tipo"),
						rs.getInt("duracion_dias"),
						
						null
					);
				enfermedades.add(enfermedad);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		closeConnection();
		
		return enfermedades;
		
	}

	@Override
	public Enfermedad buscarPorId(int id) {
		connection = openConnection();
		String query = "select * from enfermedades where id = ?";
		Enfermedad  Enfermedad  = null;
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
				
			while (rs.next()) {
				Enfermedad  = new Enfermedad (
							rs.getInt("id"),
							rs.getString("nombre"),
							rs.getString("tipo"),
							rs.getInt("duracion_dias"),
							null
						);
				//Enfermedad.setPersonas(obtenerPersonas(Enfermedad));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
		
		return Enfermedad;
	}
	

	@Override
	public void insertar(Enfermedad e) {
		// TODO Auto-generated method stub
				connection = openConnection();
				
				String query = "insert into temporadas (id, nombre,tipo,duracion_dias,persona_id) values (?, ?, ?, ?, ?)";
				
				try {
					PreparedStatement ps = connection.prepareStatement(query);
					ps.setInt(1, e.getId());
					ps.setString(2,e.getNombre());
					ps.setInt(3,e.getDuracion_dias());
					ps.setInt(4,e.getPersona().getId());
					ps.executeUpdate();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				closeConnection();
			}

	@Override
	public void modificar(Enfermedad enfermedad) {
		// TODO Auto-generated method stub
		connection = openConnection();
		int id = enfermedad.getId();
		String nombre = enfermedad.getNombre();
		String tipo = enfermedad.getTipo();
		int duracion_dias = enfermedad.getDuracion_dias();
		Persona persona= enfermedad.getPersona();
		
		String query = "update temporadas set nombre = ?, tipo = ?, "
				+ "duracion_dias = ? where id = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ps.setString(2, nombre);
			ps.setString(3, tipo);
			ps.setInt(5, duracion_dias);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		closeConnection();
	}

	
	
	
	
	
	@Override
	public void borrar(Enfermedad t) {
		connection = openConnection();
		 
		 int id=t.getId();
	        String query = "DELETE FROM enfermedades where id=?;";
	        try {
	            PreparedStatement ps = connection.prepareStatement(query);
	            ps.setInt(1, t.getId());
	            ps.executeUpdate();
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
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
		 closeConnection();
	}

	public void borrarPorpersona (int persona_id) {
		
		connection = openConnection();
		String quuery="DELETE FROM enfermedades WHERE persona_id=?";
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