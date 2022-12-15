package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.protocol.Resultset;

import pojo.Enfermedad;
import pojo.Persona;
import util.DataBaseConnection;

/**
 * clase que contien los metodos para interactuar con la clase persona
 */
public class PersonaDao extends ObjetoDao implements InterfazDao<Persona> {

	/**
	 * sirbe para buscar toad las personas
	 */
	public ArrayList<Persona> buscarTodos() {
		connection = openConnection();
		ArrayList<Persona> personas = new ArrayList<Persona>();
		String query = "select * from personas";
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				ArrayList<Enfermedad> enfermedades = new ArrayList<Enfermedad>();

				Persona persona = new Persona(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellidoUno"),
						rs.getString("apellidoDos"), rs.getInt("edad"), null);
				String query_enfermedades = "select * from enfermedades where persona_id = ?";
				PreparedStatement ps_enfermedades = connection.prepareStatement(query_enfermedades);
				ps_enfermedades.setInt(1, rs.getInt("id"));
				ResultSet rs_enfermedades = ps_enfermedades.executeQuery();
				while (rs_enfermedades.next()) {
					Enfermedad enfermedad = new Enfermedad(rs_enfermedades.getInt("id"),
							rs_enfermedades.getInt("dias_curacion"), rs_enfermedades.getString("nombre")

					);

					enfermedades.add(enfermedad);

				}
				persona.setEnfermedades(enfermedades);

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
	/**
	 * Sirve par buscar por id de la persona
	 */
	public Persona buscarPorId(int id) {

		connection = openConnection();
		String query = "select * from personas where id = ?";
		Persona persona = null;

		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				persona = new Persona(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellidoUno"),
						rs.getString("apellidoDos"), rs.getInt("edad"), null);
				persona.setEnfermedades(obtenerEnfermedades(persona));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();

		return persona;
	}

	@Override
	/**
	 * sirve pa insetar la persona
	 */
	public void insertar(Persona persona) {
		connection = openConnection();

		String query = "insert into personas (nombre,apellidoUno,apellidoDos,edad)" + "values(?,?,?,?)";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, persona.getNombre());
			ps.setString(2, persona.getApellidoUno());
			ps.setString(3, persona.getApellidoDos());
			ps.setInt(4, persona.getEdad());

			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
	}

	@Override
	/**
	 * sirve para modificar la persona
	 */
	public void modificar(Persona persona) {
		// TODO Auto-generated method stub

		connection = openConnection();

		int id = persona.getId();
		String nombre = persona.getNombre();
		String apellidoUno = persona.getApellidoUno();
		String apellidoDos = persona.getApellidoDos();
		int edad = persona.getEdad();
		String query = "update personas set nombre = ?, apellidoUno = ?, apellidoDos = ?, " + "edad = ? where id = ?";

		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, nombre);
			ps.setString(2, apellidoUno);
			ps.setString(3, apellidoDos);
			ps.setInt(4, edad);
			ps.setInt(5, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		closeConnection();

	}

	/**
	 * sirve para obtener las enfermedades segun la persona que las tenga
	 * 
	 * @param persona es el valor de la persona
	 * @return
	 */
	public ArrayList<Enfermedad> obtenerEnfermedades(Persona persona) {
		ArrayList<Enfermedad> enfermedades = new ArrayList<>();

		connection = openConnection();

		String query = "SELECT * FROM enfermedades WHERE persona_id = ?";

		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, persona.getId());
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Enfermedad enfermedad = new Enfermedad(rs.getInt("id"), rs.getInt("dias_curacion"),
						rs.getString("nombre"), persona);

				enfermedades.add(enfermedad);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// closeConnection();

		return enfermedades;
	}

	@Override
	/**
	 * sirve para borrar la persona
	 */
	public void borrar(Persona persona) {
		// TODO Auto-generated method stub
		connection = openConnection();
		int persona_id = persona.getId();

		EnfermedadDao enfermedadDao = new EnfermedadDao();
		enfermedadDao.borrarPorpersona(persona_id);
		connection = openConnection();

		String query = "DELETE FROM personas where id=?;";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, persona.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();

	}

}
