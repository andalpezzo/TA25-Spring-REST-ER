package ta25.spring.e4.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "salas") //En caso que la tabla sea diferente
public class Salas {

	//Atributos de la entidad salas
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;

	@ManyToOne
	@JoinColumn(name = "pelicula")
	private Peliculas pelicula;

	//Constructores
	public Salas() {

	}

	public Salas(Long id, String nombre, Peliculas pelicula) {
		// super();
		this.id = id;
		this.nombre = nombre;
		this.pelicula = pelicula;
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

	public Peliculas getPelicula() {
		return pelicula;
	}

	public void setPelicula(Peliculas pelicula) {
		this.pelicula = pelicula;
	}

	@Override
	public String toString() {
		return "Salas [id=" + id + ", nombre=" + nombre + ", pelicula=" + pelicula + "]";
	}
}