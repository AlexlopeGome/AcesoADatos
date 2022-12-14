package dao;

import java.util.ArrayList;

public interface InterfazDao <T>{
	/**
	 * muestra todo los objetos T
	 * @return iun arrayList de objetos T de la base de datos
	 */
	public ArrayList <T>buscarTodos();
	/**
	 * muestra el objeto T con el id especificado
	 * @param 			i el id del objeto t
	 * @returnun 		objeto T
	 */
	public T buscarPorId(int i);
	/**
	 * busca por id un Objeto T de la base de datos
	 * @param t
	 */
	
	public void insertar(T t);
	/**
	 * inserta  un Objeto T de la base de datos
	 * @param t
	 */
	
	public void modificar(T t);
	/**
	 * modifica un Objeto T de la base de datos
	 * @param t
	 */
	
	public void borrar(T t);
	
	/**
	 * borrar un Objeto T de la base de datos
	 * @param t
	 */
}
