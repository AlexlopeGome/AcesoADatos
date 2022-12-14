package main;

import java.util.ArrayList;

import dao.PersonaDao;
import dao.EnfermedadDao;
import pojo.Persona;
import pojo.Enfermedad;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Persona p1 = new Persona("Alex", "Lopez Gomez", 38);

		PersonaDao personaDao = new PersonaDao();
		personaDao.insertar(p1);
		
		System.out.println(personaDao.buscarPorId(1));
		
		Persona persona = personaDao.buscarPorId(1);
		System.out.println(persona);
		EnfermedadDao enfermedadDao=new EnfermedadDao();
		
		Enfermedad e1 = new Enfermedad(70,"Gripe",persona);
		Enfermedad e2 = new Enfermedad(40,"Neumonia",persona);
				
		
		
		System.out.println(e1);
		System.out.println(e2);

		enfermedadDao.insertar(e1);
		enfermedadDao.insertar(e2);

		Persona p2 = new Persona("Juan", "martinez Campos", 55);
		personaDao.insertar(p2);
		Persona Alex_Lopez = personaDao.buscarPorId(1);
		Alex_Lopez.setApellidos("Lopez Garcia");
		personaDao.modificar(Alex_Lopez);

		ArrayList<Persona> personas = personaDao.buscarTodos();
		for (Enfermedad enfermedad : persona.getEnfermedades()) {
	
			System.out.println("PERSONA: " + persona.getNombre());
		
	

		}
	}
}
