package ta25.spring.e3.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cajas") // en caso que la tabla sea diferente
public class Cajas {

	// Atributos de entidad Cajas
	@Id
	@Column(name = "num_ref")
	private Long numRef;
	private String contenido;
	
	private long valor;

	@ManyToOne
	@JoinColumn(name = "almacen")
	private Almacenes almacen;

	// Constructores
	public Cajas() {

	}

	public Cajas(Long numRef, String nombre, long valor, Almacenes almacen) {
		// super();
		this.numRef = numRef;
		this.contenido = nombre;
		this.valor = valor;
		this.almacen = almacen;
	}

	//Getters y Setters
	public Long getNumRef() {
		return numRef;
	}

	public void setNumRef(Long numRef) {
		this.numRef = numRef;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public long getValor() {
		return valor;
	}

	public void setValor(long valor) {
		this.valor = valor;
	}

	public Almacenes getAlmacen() {
		return almacen;
	}

	public void setAlmacen(Almacenes almacen) {
		this.almacen = almacen;
	}

	@Override
	public String toString() {
		return "Cajas [numRef=" + numRef + ", contenido=" + contenido + ", valor=" + valor + ", almacen="
				+ almacen + "]";
	}

}