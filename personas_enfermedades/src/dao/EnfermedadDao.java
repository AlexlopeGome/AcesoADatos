package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pojo.Persona;
import pojo.Enfermedad;
import util.DataBaseConnection;

/**
 * Clase q contine diferentes metodoa que usaremos para poder interanctuar con
 * la clase enfermedad en base de datos
 * 
 */
public class EnfermedadDao extends ObjetoDao implements InterfazDao<Enfermedad> {

	private static Connection connection;

	public ArrayList<Enfermedad> buscarTodos() {
		connection = openConnection();
		ArrayList<Enfermedad> enfermedades = new ArrayList<Enfermedad>();
		String query = "select * from enfermedades";
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				ArrayList<Persona> personas = new ArrayList<Persona>();

				Enfermedad enfermedad = new Enfermedad(rs.getInt("id"), rs.getInt("dias_curacion"),
						rs.getString("nombre"), null);
				String query_personas = "select * from personas where enfermedad_id = ?";
				PreparedStatement ps_personas = connection.prepareStatement(query_personas);
				ps_personas.setInt(1, rs.getInt("id"));
				ResultSet rs_personas = ps_personas.executeQuery();
				while (rs_personas.next()) {
					Persona persona = new Persona(rs_personas.getInt("id"), rs_personas.getString("nombre"),
							rs_personas.getString("apellidoUno"), rs_personas.getString("apellidoDos"),
							rs_personas.getInt("edad")

					);

					personas.add(persona);

				}
				enfermedad.setPersonas(personas);

				enfermedades.add(enfermedad);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		closeConnection();

		return enfermedades;

	}

	/**
	 * contructor bacio necesario para crear un objeto enfermedadEngermedad DAO
	 */
	public EnfermedadDao() {

	}

	@Override
	/**
	 * metodo para buscar por id donde la id es el balor del Id de la enfermedad
	 */
	public Enfermedad buscarPorId(int id) {
		connection = openConnection();
		String query = "select * from enfermedades where id = ?";
		Enfermedad enfermedad = null;

		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				enfermedad = new Enfermedad(rs.getInt("dias_curacion"), rs.getString("nombre"), null);
				enfermedad.setPersonas(obtenerPersonas(enfermedad));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();

		return enfermedad;
	}

	@Override
	/**
	 * funcion para insertar enfermedad
	 */
	public void insertar(Enfermedad eF) {
		// TODO Auto-generated method stub
		connection = openConnection();

		String query = "insert into enfermedades (dias_curacion, nombre," + "persona_id) values (?, ?, ?)";

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
	/**
	 * funcion pra modificar la enfermedad
	 */
	public void modificar(Enfermedad enfermedad) {
		// TODO Auto-generated method stub

		connection = openConnection();

		int id = enfermedad.getId();
		int dias_curacion = enfermedad.getDias_curacion();
		String nombre = enfermedad.getNombre();
		Persona persona = enfermedad.getPersona();
		String nombre_per = persona.getNombre();

		String query = "update enfermedades set nombre = ?, edad = ?, "
				+ "apellidoUno = ?,apellidoDos = ? where id = ?";

		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ps.setInt(2, dias_curacion);
			ps.setString(3, nombre);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		closeConnection();

	}

	@Override
	/**
	 * funcion que borra la enfermedad
	 */
	public void borrar(Enfermedad e) {
		// TODO Auto-generated method stub

		connection = openConnection();

		int id = e.getId();
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

	/**
	 * funcion q obsiene tops las peronas que tienen un enfermedad
	 * 
	 * @param enfermedad
	 * @return retorna las personas
	 */

	public ArrayList<Persona> obtenerPersonas(Enfermedad enfermedad) {
		ArrayList<Persona> personas = new ArrayList<>();

		connection = openConnection();

		String query = "SELECT * FROM personas WHERE enfermedad_id = ?";

		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, enfermedad.getId());
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Persona persona = new Persona(rs.getString("nombre"), rs.getString("dias_curacion"),
						rs.getString("nombre"), rs.getInt("edad"), enfermedad);

				personas.add(persona);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// closeConnection();

		return personas;
	}

	/**
	 * funcion para borrar la persona segun su id
	 * 
	 * @param persona_id
	 */
	public void borrarPorpersona(int persona_id) {

		connection = openConnection();
		String quuery = "DELETE FROM enfermedades WHERE persona_id=?";
		try {
			PreparedStatement ps = connection.prepareStatement(quuery);
			ps.setInt(1, persona_id);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		closeConnection();

	}

	/**
	 * funcion para abrir la coneccion con base de datos
	 * 
	 * @return retorna la coneccion
	 */
	protected static Connection openConnection() {
		DataBaseConnection dbConnection = new DataBaseConnection();
		connection = dbConnection.getConnection();
		return connection;
	}

	/**
	 * Funcion par cerrar la conecion con base de datos
	 */
	protected static void closeConnection() {
		try {
			connection.close();
			connection = null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}