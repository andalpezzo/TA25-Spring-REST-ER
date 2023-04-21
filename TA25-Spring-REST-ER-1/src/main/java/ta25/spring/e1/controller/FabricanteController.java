package ta25.spring.e1.controller;

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

import ta25.spring.e1.dto.Fabricante;
import ta25.spring.e1.service.FabricanteService;

@RestController
@RequestMapping("/api")
public class FabricanteController {
	
	@Autowired
	FabricanteService fabricanteService;

	@GetMapping("/fabricantes")
	public List<Fabricante> listFabricantes() {
		return fabricanteService.listFabricantes();
	}

	@GetMapping("/fabricantes/{id}")
	public Fabricante fabricanteById(@PathVariable(name = "id") Long id) {
		Fabricante fabricantexID = new Fabricante();

		fabricantexID = fabricanteService.FabricanteById(id);

		return fabricantexID;
	}

	@PostMapping("/fabricantes")
	public Fabricante saveFabricante(@RequestBody Fabricante fabricante) {
		return fabricanteService.saveFabricante(fabricante);
	}

	@PutMapping("/fabricantes/{id}")
	public Fabricante updateFabricante(@PathVariable(name = "id") Long id, @RequestBody Fabricante fabricante) {
		Fabricante selectedFabricante = new Fabricante(id, fabricante.getNombre());
		Fabricante updatedFabricante = new Fabricante();

		updatedFabricante = fabricanteService.updateFabricante(selectedFabricante);
		return updatedFabricante;
	}

	@DeleteMapping("/fabricantes/{id}")
	public void deleteFabricante(@PathVariable(name = "id") Long id) {
		fabricanteService.deleteFabricante(id);
	}
}