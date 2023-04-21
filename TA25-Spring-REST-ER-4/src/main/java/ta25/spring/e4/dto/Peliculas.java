package ta25.spring.e4.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "peliculas") //En caso que la tabla sea diferente
public class Peliculas {

	//Atributos de la entidad peliculas
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	@Column(name = "calificacion_edad")
	private int calificacionEdad;

	@OneToMany
	@JoinColumn(name = "codigo")
	private List<Salas> salas;

	//Constructores
	public Peliculas() {

	}

	public Peliculas(Long id, String nombre, int calificacionEdad) {
		// super();
		this.id = id;
		this.nombre = nombre;
		this.calificacionEdad = calificacionEdad;

	}

	//Getters y Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCalificacionEdad() {
		return calificacionEdad;
	}

	public void setCalificacionedad(int calificacionEdad) {
		this.calificacionEdad = calificacionEdad;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "")
	public List<Salas> getSalas() {
		return salas;
	}

	public void setSalas(List<Salas> salas) {
		this.salas = salas;
	}

	@Override
	public String toString() {
		return "Peliculas [id=" + id + ", nombre=" + nombre + ", calificacionEdad=" + calificacionEdad + ", salas="
				+ salas + "]";
	}
}