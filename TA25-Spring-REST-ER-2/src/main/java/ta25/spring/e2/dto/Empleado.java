package ta25.spring.e2.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "empleados")
public class Empleado {

	@Id
	private String dni;
	private String nombre;
	private String apellidos;

	@ManyToOne()
	@JoinColumn(name = "departamentos")
	private Departamentos departamentos;

	public Empleado() {
	}

	public Empleado(String dni, String nombre, String apellidos, Departamentos departamentos) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.departamentos = departamentos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
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

	public Departamentos getDepartamento() {
		return departamentos;
	}

	public void setDepartamento(Departamentos departamentos) {
		this.departamentos = departamentos;
	}

	@Override
	public String toString() {
		return "Empleado [dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + ", departamentos="
				+ departamentos + "]";
	}
}
