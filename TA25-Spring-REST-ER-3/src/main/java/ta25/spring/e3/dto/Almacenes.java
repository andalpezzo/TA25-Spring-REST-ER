package ta25.spring.e3.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "almacenes") //en caso que la tabla sea diferente
public class Almacenes {

	//Atributos de entidad almacenes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;
	private String lugar;
	private long capacidad;

	@OneToMany
	@JoinColumn(name = "codigo")
	private List<Cajas> cajas;

	//Constructores
	public Almacenes() {

	}

	public Almacenes(Long id, String nombre, long capacidad) {
		//super();
		this.id = id;
		this.lugar = nombre;
		this.capacidad = capacidad;

	}

	//Getters y Setters
	public Long getId() {
		return id;
	}

	public void setId(Long codigo) {
		this.id = codigo;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public long getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(long capacidad) {
		this.capacidad = capacidad;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "")
	public List<Cajas> getCajas() {
		return cajas;
	}

	public void setCajas(List<Cajas> cajas) {
		this.cajas = cajas;
	}

	@Override
	public String toString() {
		return "Almacenes [id=" + id + ", lugar=" + lugar + ", capacidad=" + capacidad + ", cajas=" + cajas + "]";
	}
}