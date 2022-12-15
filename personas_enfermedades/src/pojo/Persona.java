package pojo;

import java.util.ArrayList;

/***
 * clase conpuesta de los valores delas una persona
 */
public class Persona {

	private int id;
	private String nombre;
	private String apellidoUno;
	private String apellidoDos;
	private int edad;
	private ArrayList<Enfermedad> enfermedades;
	private Enfermedad enfermedad;

	/**
	 * clase para contruir una persona con los valores
	 * 
	 * @param nombre      de la persona
	 * @param apellidoUno de la persona
	 * @param apellidoDos de la persona
	 * @param edad        de la persona
	 */
	public Persona(String nombre, String apellidoUno, String apellidoDos, int edad) {
		super();
		this.nombre = nombre;
		this.apellidoUno = apellidoUno;
		this.apellidoDos = apellidoDos;
		this.edad = edad;

	}

	/**
	 * clase para contruir una persona con los valores
	 * 
	 * @param id           de la persona
	 * @param nombre       de la persona
	 * @param apellidoUno  de la persona
	 * @param apellidoDos  de la persona
	 * @param edad         de la persona
	 * @param enfermedades de la persona
	 */
	public Persona(int id, String nombre, String apellidoUno, String apellidoDos, int edad,
			ArrayList<Enfermedad> enfermedades) {
		this.id = id;
		this.nombre = nombre;
		this.apellidoUno = apellidoUno;
		this.apellidoDos = apellidoDos;
		this.edad = edad;
		this.enfermedades = enfermedades;
	}

	/**
	 * clase para contruir una persona con los valores
	 * 
	 * @param id          de la persona
	 * @param nombre      de la persona
	 * @param apellidoUno de la persona
	 * @param apellidoDos de la persona
	 * @param edad        de la persona
	 */
	public Persona(int id, String nombre, String apellidoUno, String apellidoDos, int edad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidoUno = apellidoUno;
		this.apellidoDos = apellidoDos;
		this.edad = edad;
	}

	/**
	 * clase para contruir una persona con los valores
	 * 
	 * @param nombrede    la persona
	 * @param apellidoUno de la persona
	 * @param apellidoDos de la persona
	 * @param edad        de la persona
	 * @param enfermedad  de la persona
	 */
	public Persona(String nombre, String apellidoUno, String apellidoDos, int edad, Enfermedad enfermedad) {
		super();
		this.nombre = nombre;
		this.apellidoUno = apellidoUno;
		this.apellidoDos = apellidoDos;
		this.edad = edad;
		this.enfermedad = enfermedad;
	}

	/**
	 * la usamos para mostrar la id
	 * 
	 * @return es la id de la persona
	 */
	public int getId() {
		return id;
	}

	/**
	 * lo usamos para insetar el id
	 * 
	 * @param id es la id de la persona
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * lo usamos para motrar el nombre
	 * 
	 * @return es el nombre a mostar
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * lo usmos para insetar el nombre
	 * 
	 * @param nombre es el nombre a insetar
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * lo usamos pra motrar el primer apellido
	 * 
	 * @return debuelbe el valo del apellido
	 */
	public String getApellidoUno() {
		return apellidoUno;
	}

	/**
	 * lo usamos para insetar el apellido
	 * 
	 * @param apellidoUno es el apellido
	 */
	public void setApellidoUno(String apellidoUno) {
		this.apellidoUno = apellidoUno;
	}

	/**
	 * lo usamos para mostar el apellido segundo
	 * 
	 * @return devuelve el apelledos segundo
	 */
	public String getApellidoDos() {
		return apellidoDos;
	}

	/**
	 * los usamos para introducir el segundo apellido
	 * 
	 * @param apellidoDos es valor del apellido
	 */
	public void setApellidoDos(String apellidoDos) {
		this.apellidoDos = apellidoDos;
	}

	/**
	 * lo usamos para mostar la edad de la persoma
	 * 
	 * @return debuelve el volor de la edad
	 */
	public int getEdad() {
		return edad;
	}

	/**
	 * lo usamos para insetar la edcad
	 * 
	 * @param edad es la valo de la edad
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}

	/**
	 * la suamos para mostar las enfermedades
	 * 
	 * @returndebuelve las enfermedades
	 */
	public ArrayList<Enfermedad> getEnfermedades() {
		return enfermedades;
	}

	/**
	 * la usamos para insetar las enfermedasdes
	 * 
	 * @param enfermedades es el valor de las enfermedades
	 */
	public void setEnfermedades(ArrayList<Enfermedad> enfermedades) {
		this.enfermedades = enfermedades;
	}

	/**
	 * es valor la enfermedad
	 * 
	 * @return debuelve la enfermedad
	 */
	public Enfermedad getEnfermedad() {
		return enfermedad;
	}

	/**
	 * los usdamo para insertar la enfermedad
	 * 
	 * @param enfermedad es el valor de la enfemedad
	 */
	public void setEnfermedad(Enfermedad enfermedad) {
		this.enfermedad = enfermedad;
	}

	/**
	 * lo usmops para poder imprimir la persona con los valores
	 */
	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", apellidoUno=" + apellidoUno + ", apellidoDos="
				+ apellidoDos + ", edad=" + edad + ", enfermedades=" + enfermedades + ", enfermedad=" + enfermedad
				+ "]";
	}

}
