package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pojo.Enfermedad;
import pojo.Persona;


public class PersonaDao extends  ObjetoDao implements InterfazDao<Persona> {

	@Override
	public ArrayList<Persona> buscarTodos() {
		connection=openConnection();
		ArrayList<Persona> personas=new ArrayList<Persona>();
		String query="select * from series";
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			
			while (rs.next()) {
				Persona persona = new Persona(
						rs.getInt("id"),
						rs.getString("nombre"),
						rs.getString("apellidos"),
						rs.getInt("edad")
					
					);
				personas.add(persona);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		closeConnection();
		
		return personas;
	
	}

	@Override
	public Persona buscarPorId(int id) {
		connection = openConnection();
		String query = "select * from series where id = ?";
		Persona  serie = null;
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
				
			while (rs.next()) {
				Persona persona = new Persona(
						rs.getInt("id"),
						rs.getString("nombre"),
						rs.getString("apellidos"),
						rs.getInt("edad")
						);
				persona.setEnfermedades(obtenerTemporadas(persona) );
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
		
		return serie;
	}
	@Override
	public void insertar(Persona persona) {
connection= openConnection();
		
		String query= "insert into personas (nombre,apellidos,edad,)"
				+"values(?,?,?)";
		try {
			PreparedStatement ps= connection.prepareStatement(query);
			ps.setString(1, persona.getNombre());
			ps.setString(2, persona.getApellidos());
			ps.setInt(3, persona.getEdad());
			ps.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
	}
	

	@Override
	public void modificar(Persona persona) {
		// TODO Auto-generated method stub
connection = openConnection();
		
		int id = persona.getId();
		String nombre = persona.getNombre();
		String apellidos=persona.getApellidos();
		int edad = persona.getEdad();
		
		String query = "update persona set nombre = ?, apellidos = ?, "
				+ "edad = ? where id = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, persona.getNombre());
			ps.setString(2, persona.getApellidos());
			ps.setInt(3, persona.getEdad());
			ps.setInt(4, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		closeConnection();
		
	}

	public ArrayList<Enfermedad> obtenerTemporadas(Persona persona) {
		ArrayList<Enfermedad> enfermedades = new ArrayList<>();
		
		connection = openConnection();
		
		String query = "SELECT * FROM enfermedades WHERE persona_id = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, persona.getId());
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Enfermedad enfermedad = new Enfermedad(
						rs.getInt("id"),
						rs.getString("nombre"),
						rs.getString("tipo"),
						rs.getInt("duracion_dias"),
						persona
						);
				
				enfermedades.add(enfermedad);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//closeConnection();
		
		return enfermedades;
	}

	
	
	
	@Override
	public void borrar(Persona t) {
		// TODO Auto-generated method stub
		
	}

}
