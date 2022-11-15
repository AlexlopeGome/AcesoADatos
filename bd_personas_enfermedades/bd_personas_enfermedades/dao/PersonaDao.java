package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
	public Persona buscarPorId(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertar(Persona t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificar(Persona t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void borrar(Persona t) {
		// TODO Auto-generated method stub
		
	}

}
