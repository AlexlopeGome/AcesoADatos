package pojo;

public class Enfermedad {
	
	private int id;
	private String nombre;
	private String tipo;
	private int duracion_dias;
	private Persona persona;
	public Enfermedad(int id, String nombre, String tipo, int duracion_dias, Persona persona) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.tipo = tipo;
		this.duracion_dias = duracion_dias;
		this.persona = persona;
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
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getDuracion_dias() {
		return duracion_dias;
	}
	public void setDuracion_dias(int duracion_dias) {
		this.duracion_dias = duracion_dias;
	}
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	@Override
	public String toString() {
		return "Enfermedad id:" + id + ", nombre:" + nombre + ", tipo:" + tipo + ", duracion :" + duracion_dias+" dias."
				+ "Paciente:" + persona ;
	}
	
	

}
