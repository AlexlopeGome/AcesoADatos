package pojo;

import java.util.ArrayList;

public class Persona {
	
	private int id;
	private String nombre;
	private String apellidos;
	private int edad;
	private ArrayList<Enfermedad>enfermedades;
	
	public Persona(String nombre, String apellidos,int edad) {
		super();
		this.nombre=nombre;
		this.apellidos = apellidos;
		this.edad = edad;
		
	}

	public Persona(int id, String nombre, String apellidos, int edad, ArrayList<Enfermedad> enfermedades) {
		this.id = id;
		this.nombre=nombre;
		this.apellidos = apellidos;
		this.edad = edad;
		this.enfermedades=enfermedades;
	}

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public ArrayList<Enfermedad> getEnfermedades() {
		return enfermedades;
	}

	public void setEnfermedades(ArrayList<Enfermedad> enfermedades) {
		this.enfermedades = enfermedades;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", edad=" + edad
				+ ", enfermedades=" + enfermedades + "]";
	}


	

}



