package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import pojo.Serie;
import pojo.Temporada;
import util.DataBaseConnection;


public class TemporadaDao extends ObjetoDao  implements InterfazDao<Temporada> {
	
	private static Connection connection;
	
	public TemporadaDao () {
		
	}

	


	@Override
	public Temporada buscarPorId(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertar(Temporada t) {
		// TODO Auto-generated method stub
		connection = openConnection();
		
		String query = "insert into temporadas (num_temporada, titulo, "
				+ "serie_id) values (?, ?, ?)";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, t.getNum_temporada());
			ps.setString(2, t.getTitulo());
			ps.setInt(3, t.getSerie().getId()); 
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		closeConnection();
	}

	@Override
	public void modificar(Temporada temporada) {
		// TODO Auto-generated method stub
		
connection = openConnection();
		
		int id= temporada.getId();
		int numero_temporada= temporada.getNum_temporada();
		String titulo = temporada.getTitulo();
		Serie serie= temporada.getSerie();
		String plataforma = serie.getPlataforma();
		
		String query = "update temporadas set titulo = ?, edad = ?, "
				+ "plataforma = ? where id = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1,id );
			ps.setInt(2, numero_temporada);
			ps.setString(3, titulo);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		closeConnection();
		
	}
		
	

	@Override
	public void borrar(Temporada t) {
		// TODO Auto-generated method stub
		
		 connection = openConnection();
		 
		 int id=t.getId();
	        String query = "DELETE FROM temporadas where id=?;";
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




	@Override
	public ArrayList<Temporada> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}
	public void borrarPorserie (int serie_id) {
		
		connection = openConnection();
		String quuery="DELETE FROM temporadas WHERE serie_id=?";
		try {
			PreparedStatement ps= connection.prepareStatement(quuery);
			ps.setInt(1, serie_id);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	
		 closeConnection();

	}
	
}