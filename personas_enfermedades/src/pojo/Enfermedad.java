package pojo;

import java.util.ArrayList;

import dao.PersonaDao;

/**
 * clase compuesta de las variables de las enfermedades
 */
public class Enfermedad {

	private int id;
	private int dias_curacion;
	private String nombre;
	private Persona persona;
	private int id_persona;
	private ArrayList<Persona> personas;

	/**
	 * contructor para crear una enfermedad cpn los sigientes paramentros
	 * 
	 * @param id            de la enfermedad
	 * @param dias_curacion de la enfermedad
	 * @param nombre        de la enfermedad
	 * @param persona       en tiena la enfermedad
	 */
	public Enfermedad(int id, int dias_curacion, String nombre, Persona persona) {
		super();
		this.id = id;
		this.dias_curacion = dias_curacion;
		this.nombre = nombre;
		this.persona = persona;
	}

	/**
	 * contructor para crear una enfermedad cpn los sigientes paramentros
	 * 
	 * @param id            de la enfermedad
	 * @param dias_curacion de la enfermedad
	 * @param nombre        de la enfermedad
	 */

	public Enfermedad(int id, int dias_curacion, String nombre) {
		super();
		this.id = id;
		this.dias_curacion = dias_curacion;
		this.nombre = nombre;
	}

	/**
	 * contructor para crear una enfermedad cpn los sigientes paramentros
	 * 
	 * @param dias_curacion de la enfermedad
	 * @param nombre        de la enfermedad
	 * @param persona       de la enfermedad
	 */
	public Enfermedad(int dias_curacion, String nombre, Persona persona) {
		super();
		this.dias_curacion = dias_curacion;
		this.nombre = nombre;
		this.persona = persona;
	}

	/**
	 * get mostrar el valor de la id
	 * 
	 * @return la id de la enfermedad
	 */
	public int getId() {
		return id;
	}

	/**
	 * set que sirve para insertar
	 * 
	 * @param id a insertar
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * get mostrar el valor de los dias de curacion
	 * 
	 * @return los dias de curacion
	 */
	public int getDias_curacion() {
		return dias_curacion;
	}

	/**
	 * set que sirve para insertar
	 * 
	 * @param dias_curacion a insertar
	 */

	public void setDias_curacion(int dias_curacion) {
		this.dias_curacion = dias_curacion;
	}

	/**
	 * qet que sirve par mostrar el nombre de la enfermedad
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * set q usamos para intertar el nombre
	 * @param nombre de la enfermedad
	 */

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * get par mostrar la persona
	 * @return de buelve la persona
	 */

	public Persona getPersona() {
		return persona;
	}

	/**
	 * set para inserta la persona
	 * @param persona person q tiene la enfermedad 
	 */
	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	/**
	 * get que muestra la id de la persona
	 * @return debuelve la id de la persona
	 */

	public int getId_persona() {
		return id_persona;
	}

	/**
	 * set q usamos para insertar la id de la persona
	 * @param id_persona la id a in sertar
	 */

	public void setId_persona(int id_persona) {
		this.id_persona = id_persona;
	}

	/**
	 * get que muestra las persona q tienen la enfermedad
	 * @return debuel las persona
	 */

	public ArrayList<Persona> getPersonas() {
		return personas;
	}

	/**
	 * set para insertar las personas
	 * @param personas son las persona
	 */
	public void setPersonas(ArrayList<Persona> personas) {
		this.personas = personas;
	}

	/**
	 * lo usamos para poder mostrar los valoes 
	 */
	@Override
	public String toString() {
		return "Enfermedad [id=" + id + ", dias_curacion=" + dias_curacion + ", nombre=" + nombre + ", Paciente: "
				+ persona.getNombre();
	}

}
