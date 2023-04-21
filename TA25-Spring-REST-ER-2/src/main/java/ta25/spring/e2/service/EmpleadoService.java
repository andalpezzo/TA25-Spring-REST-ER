package ta25.spring.e2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ta25.spring.e2.dto.Empleado;
import ta25.spring.e2.dao.EmpleadoDAO;

@Service
public class EmpleadoService {
	@Autowired
	EmpleadoDAO empleadoDAO;

	public List<Empleado> listEmpleados() {
		return empleadoDAO.findAll();
	}

	public Empleado saveEmpleado(Empleado empleado) {
		return empleadoDAO.save(empleado);
	}

	public Empleado EmpleadoById(String dni) {
		return empleadoDAO.findById(dni).get();
	}

	public Empleado updateEmpleado(Empleado empleado) {
		return empleadoDAO.save(empleado);
	}

	public void deleteEmpleado(String dni) {
		empleadoDAO.deleteById(dni);
	}
}
