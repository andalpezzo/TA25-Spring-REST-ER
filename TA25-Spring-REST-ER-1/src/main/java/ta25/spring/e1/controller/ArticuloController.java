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

import ta25.spring.e1.dto.Articulo;
import ta25.spring.e1.service.ArticuloService;

@RestController
@RequestMapping("/api")
public class ArticuloController {
	
	@Autowired
	ArticuloService articuloService;

	@GetMapping("/articulos")
	public List<Articulo> listArticulos() {
		return articuloService.listArticulos();
	}

	@GetMapping("/articulos/{id}")
	public Articulo articuloById(@PathVariable(name = "id") Long id) {
		Articulo articuloById = new Articulo();
		articuloById = articuloService.ArticuloById(id);
		return articuloById;
	}

	@PostMapping("/articulos")
	public Articulo saveArticulo(@RequestBody Articulo articulo) {
		return articuloService.saveArticulo(articulo);
	}

	@PutMapping("/articulos/{id}")
	public Articulo updateArticulo(@PathVariable(name = "id") Long id, @RequestBody Articulo articulo) {
		Articulo articulo_Selected = new Articulo(id, articulo.getNombre(), articulo.getPrecio(),
				articulo.getFabricante());
		Articulo articulo_Updated = new Articulo();

		articulo_Updated = articuloService.updateArticulo(articulo_Selected);

		return articulo_Updated;
	}

	@DeleteMapping("/articulos/{id}")
	public void deleteArticulo(@PathVariable(name = "id") Long id) {
		articuloService.deleteArticulo(id);
	}
}
