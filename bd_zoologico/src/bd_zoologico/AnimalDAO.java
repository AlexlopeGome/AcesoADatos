package bd_zoologico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.cj.xdevapi.PreparableStatement;

import util.DataBaseConnection;

public abstract class AnimalDAO {

	private static Connection connection;
	///	Modificar un animal
	public static void updateAnimal (Animal animal) {
		connection = openConnection();
		
		int id = animal.getId();
		String nombre = animal.getNombre();
		String habitat = animal.getHabitat();
		double peso_aproximado = animal.getPeso_aproximado();
		
		String query = "update animales set nombre = ?, habitat = ?, "
				+ "peso_aproximado = ? where id = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, nombre);
			ps.setString(2, habitat);
			ps.setDouble(3, peso_aproximado);
			ps.setInt(4, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		closeConnection();
	}
	
public static ArrayList<Animal> findAllAnimals() {
		
		connection=openConnection();
		ArrayList<Animal> aR=new ArrayList<Animal>();
		String query="select * from animales";
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			Animal animal = null;
			while (rs.next()) {
				animal = new Animal(
						rs.getInt("id"),
						rs.getString("nombre"),
						rs.getString("habitat"),
						rs.getDouble("peso_aproximado") 
					);
				aR.add(animal);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		closeConnection();
		
		return aR;
		
	}
	
	//Buscar animal Id
	public static Animal findById(int id) {
		connection = openConnection();
		String query = "select * from animales where id = ?";
		Animal animal = null;
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				animal = new Animal(
							rs.getInt("id"),
							rs.getString("nombre"),
							rs.getString("habitat"),
							rs.getDouble("peso_aproximado") 
						);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
		
		return animal;
	}
	//borrar animal por nombre
	public static void deleteAnimalByNombre(String nombre) {
		connection = openConnection();
		String query ="delete from animales where nombre= ?";
		
		try {
		
			PreparedStatement preparestatement;
			preparestatement = connection.prepareStatement(query);
			preparestatement.setString(1, nombre);
			preparestatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
	}
		
	//borrar todos los animales
	public static void deleteAllAnimal(){
		
		connection = openConnection();
		String query ="delete from animales";
		
		try {
			/*Statement statement;
			statement = connection.createStatement();
			statement.executeUpdate(query);*/
			PreparedStatement preparestatement;
			preparestatement = connection.prepareStatement(query);
			preparestatement.executeUpdate(query);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
	}
	
	
	public static void insertAnimal(Animal animal) {
		connection = openConnection();
		
		String query="insert into animales(nombre,habitat, "+"peso_aproximado)values(?,?,?)";
	try {
		PreparedStatement preparedStatement=connection.prepareStatement(query);
		preparedStatement.setString(1, animal.getNombre());
		preparedStatement.setString(2, animal.getHabitat());
		preparedStatement.setDouble(3, animal.getPeso_aproximado());
		
		preparedStatement.executeUpdate();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}  
	closeConnection();
	
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
}
