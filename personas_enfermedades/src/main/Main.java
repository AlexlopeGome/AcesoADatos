package main;

import java.util.ArrayList;

import dao.PersonaDao;
import dao.EnfermedadDao;
import pojo.Persona;
import pojo.Enfermedad;

public class Main {
	/**
	 * clase que arranca el programa
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// creamos dos objetos persona
		Persona p1 = new Persona("Alex", "Lopez", "Gomez", 38);
		Persona p2 = new Persona("Juan", "Martinez", " Campos", 55);

		// creamos un objeto dao para instar las personas
		PersonaDao personaDao = new PersonaDao();

		// insetamos las personas en base de datos
		personaDao.insertar(p1);
		personaDao.insertar(p2);

		// las imprimimos buscanolas por id
		System.out.println(personaDao.buscarPorId(1));
		System.out.println(personaDao.buscarPorId(2));

		// creamos las personas y la igualamos para buscar el y de de ellas enbvase de
		// datos

		Persona persona = personaDao.buscarPorId(1);
		Persona persona2 = personaDao.buscarPorId(2);

		// creamos una enfermedadDao para insetarlas depues en base de datos
		EnfermedadDao enfermedadDao = new EnfermedadDao();
		// creamos las enfermedades
		Enfermedad e1 = new Enfermedad(70, "Gripe", persona);
		Enfermedad e2 = new Enfermedad(40, "Neumonia", persona2);

		// imprimimos las enfermedades para comprobar

		System.out.println(e1);
		System.out.println(e2);
		System.out.println("--------------------------");

		// las insetamos en base de datos atraves el objeo dao
		enfermedadDao.insertar(e1);
		enfermedadDao.insertar(e2);

		// buscamos una persona por id
		Persona Alex_Lopez = personaDao.buscarPorId(1);
		Alex_Lopez.setApellidoDos("Perez");
		// modificamos el segundo apellido de la persona localizada
		personaDao.modificar(Alex_Lopez);

		// bsucamos y mostramos todas las personas completas en base de datos
		ArrayList<Persona> personas = personaDao.buscarTodos();

		for (Persona persona1 : personas) {
			System.out.println("Persona: " + persona1.getNombre());
			for (Enfermedad enfermedad : persona1.getEnfermedades()) {
				System.out.println("ENFERMEDAD :" + enfermedad.getNombre());

			}

		}

		// buscamos una persona con id 2 para comprobar su estado
		Persona per = personaDao.buscarPorId(2);
		System.out.println(per);
		
		// borramos la enfermedad asijnada a la persona 2
		enfermedadDao.borrarPorpersona(2);
		
		// buscamos la persona 2 para comprobar si tiene asignada la enfermedad
		System.out.println(personaDao.buscarPorId(2));

	}
}
