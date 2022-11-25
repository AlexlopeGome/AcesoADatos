package pojo;
// Generated 25 nov. 2022 12:37:17 by Hibernate Tools 5.6.7.Final

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="animales")
/**
 * Animales generated by hbm2java
 */
public class Animal implements java.io.Serializable {
	@Id
	@Column(name ="id")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="nombre",unique=true, nullable=false ,length=40)
	private String nombre;
	
	@Column(name="habitad",nullable=false,length=40)
	private String habitat;
	
	@Column(name="peso_aproximado",nullable=false,length=10,precision=2)
	private BigDecimal pesoAproximado;

	public Animal() {
	}

	public Animal(String nombre, String habitat, BigDecimal pesoAproximado) {
		this.nombre = nombre;
		this.habitat = habitat;
		this.pesoAproximado = pesoAproximado;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getHabitat() {
		return this.habitat;
	}

	public void setHabitat(String habitat) {
		this.habitat = habitat;
	}

	public BigDecimal getPesoAproximado() {
		return this.pesoAproximado;
	}

	public void setPesoAproximado(BigDecimal pesoAproximado) {
		this.pesoAproximado = pesoAproximado;
	}

}