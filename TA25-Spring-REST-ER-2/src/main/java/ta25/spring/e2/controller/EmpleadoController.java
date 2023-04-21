package ta25.spring.e2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ta25.spring.e2.dto.Empleado;
import ta25.spring.e2.service.EmpleadoService;

@RestController
@RequestMapping("/api")
public class EmpleadoController {

	@Autowired
	EmpleadoService empleadoService;

	@GetMapping("/empleados")
	public List<Empleado> listEmpleados() {
		return empleadoService.listEmpleados();
	}

	@GetMapping("/empleados/{dni}")
	public Empleado empleadoById(@PathVariable(name = "dni") String dni) {
		Empleado empleadoById = new Empleado();
		empleadoById = empleadoService.EmpleadoById(dni);
		
		return empleadoById;
	}

	@PostMapping("/empleados")
	public Empleado saveEmpleado(@RequestBody Empleado empleado) {
		return empleadoService.saveEmpleado(empleado);
	}

	@PutMapping("/empleados/{dni}")
	public Empleado updateEmpleado(@PathVariable(name = "dni") String dni, @RequestBody Empleado empleado) {
		Empleado empleado_Selected = new Empleado(dni, empleado.getNombre(), empleado.getApellidos(),
				empleado.getDepartamento());
		Empleado empleado_Updated = new Empleado();

		empleado_Updated = empleadoService.updateEmpleado(empleado_Selected);

		return empleado_Updated;
	}

	@DeleteMapping("/empleados/{dni}")
	public void deleteEmpleado(@PathVariable(name = "dni") String dni) {
		empleadoService.deleteEmpleado(dni);
	}
}
