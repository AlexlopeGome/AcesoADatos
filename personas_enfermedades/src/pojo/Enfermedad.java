package pojo;

public class Enfermedad {

	private int id;
	private int dias_curacion;
	private String nombre;
	private Persona persona;
	private int id_persona;
	
	
	public Enfermedad(int id, int dias_curacion, String nombre, Persona persona) {
		super();
		this.id = id;
		this.dias_curacion = dias_curacion;
		this.nombre = nombre;
		this.persona = persona;
	}

	

	public Enfermedad(int id, int dias_curacion, String nombre) {
		super();
		this.id = id;
		this.dias_curacion = dias_curacion;
		this.nombre = nombre;
	}


	public Enfermedad(int dias_curacion, String nombre, Persona persona) {
		super();
		this.dias_curacion = dias_curacion;
		this.nombre = nombre;
		this.persona = persona;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public int getDias_curacion() {
		return dias_curacion;
	}



	public void setDias_curacion(int dias_curacion) {
		this.dias_curacion = dias_curacion;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public Persona getPersona() {
		return persona;
	}



	public void setPersona(Persona persona) {
		this.persona = persona;
	}



	@Override
	public String toString() {
		return "Enfermedad [id=" + id + ", dias_duracion=" + dias_curacion + ", nombre=" + nombre + ", persona="
				+ persona + "]";
	}

	
	
}
