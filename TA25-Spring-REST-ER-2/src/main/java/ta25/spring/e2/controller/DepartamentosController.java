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

import ta25.spring.e2.dto.Departamentos;
import ta25.spring.e2.service.DepartamentoService;

@RestController
@RequestMapping("/api")
public class DepartamentosController {

	@Autowired
	DepartamentoService departamentoService;

	@GetMapping("/departamentos")
	public List<Departamentos> listDepartamentos() {
		return departamentoService.listDepartamentos();
	}

	@GetMapping("/departamentos/{id}")
	public Departamentos departamentoById(@PathVariable(name = "id") Long id) {
		Departamentos departamentoxID = new Departamentos();

		departamentoxID = departamentoService.DepartamentoById(id);

		return departamentoxID;
	}

	@PostMapping("/departamentos")
	public Departamentos saveDepartamento(@RequestBody Departamentos departamento) {
		return departamentoService.saveDepartamento(departamento);
	}

	@PutMapping("/departamentos/{id}")
	public Departamentos updateDepartamento(@PathVariable(name = "id") Long id, @RequestBody Departamentos departamento) {
		Departamentos selectedDepartamento = new Departamentos(id, departamento.getNombre(),
				departamento.getPresupuesto());
		Departamentos updatedDepartamento = new Departamentos();

		updatedDepartamento = departamentoService.updateDepartamento(selectedDepartamento);
		return updatedDepartamento;
	}

	@DeleteMapping("/departamentos/{id}")
	public void deleteDepartamento(@PathVariable(name = "id") Long id) {
		departamentoService.deleteDepartamento(id);
	}
}
