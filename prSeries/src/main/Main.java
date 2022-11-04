package main;

import java.util.ArrayList;

import dao.SerieDao;
import dao.TemporadaDao;
import pojo.Serie;
import pojo.Temporada;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Serie serie = new Serie("Los Simpsons", 7, "Disney Plus");
		//SerieDao serieDao = new SerieDao();
		SerieDao serieDao = new SerieDao();
		//serieDao.insertar(serie);
		//System.out.println(serieDao.buscarPorId(1)); 
		Serie serie = serieDao.buscarPorId(1);
		//System.out.println(serie);
		
		
		Temporada t1 = new Temporada(1, "Temporada 1", serie);
		Temporada t2 = new Temporada(1, "Temporada 2", serie);
		
		TemporadaDao temporadaDao = new TemporadaDao();
		temporadaDao.insertar(t1);
		temporadaDao.insertar(t2);
		//.insertar(t2);
		
		//Serie d = new Serie("Madalorian", 7, "Disney Plus");
		//serieDao.insertar(d);
		Serie los_Simpsons= serieDao.buscarPorId(1);
		//los_Simpsons.setPlataforma("Netflix");
		//serieDao.modificar(los_Simpsons);
		
		
//		ArrayList<Serie> series= serieDao.buscarTodos();
//		for (Serie serie : series) {
//			System.out.println(serie);
//		}
		
		ArrayList<Temporada> temporadas= serieDao.obtenerTemporadas(los_Simpsons);
		for (Temporada temporada : temporadas) {
			System.out.println(temporada);
		}
		
	}

}
