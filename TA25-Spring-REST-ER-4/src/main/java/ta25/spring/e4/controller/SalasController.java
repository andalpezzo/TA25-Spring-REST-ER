package ta25.spring.e4.controller;

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

import ta25.spring.e4.dto.Salas;
import ta25.spring.e4.service.SalasService;

@RestController
@RequestMapping("/api")
public class SalasController {

	@Autowired
	SalasService salasService;
	
	@GetMapping("/salas")
	public List<Salas> listarVideos(){
		return salasService.listarSalas();
	}
	
	@PostMapping("/salas")
	public Salas salvarArticulo(@RequestBody Salas caja) {
		
		return salasService.guardarSala(caja);
	}
	
	@GetMapping("/salas/{id}")
	public Salas articuloXID(@PathVariable(name="id") long id) {
		
		Salas sala_xid= new Salas();
		
		sala_xid=salasService.salaXID(id);
		
		System.out.println("Video XID: "+sala_xid);
		
		return sala_xid;
	}
	
	@PutMapping("/salas/{id}")
	public Salas actualizarArticulo(@PathVariable(name="id")long id,@RequestBody Salas sala) {
		
		Salas sala_seleccionada= new Salas();
		Salas sala_actualizada= new Salas();
		
		sala_seleccionada= salasService.salaXID(id);
		
		sala_seleccionada.setNombre(sala.getNombre());
		sala_seleccionada.setPelicula(sala.getPelicula());
		
		sala_actualizada = salasService.actualizarSala(sala_seleccionada);
		
		System.out.println("La caja actualizada es: "+ sala_actualizada);
		
		return sala_actualizada;
	}
	
	@DeleteMapping("/salas/{id}")
	public void eliminarArticulo(@PathVariable(name="id")long id) {
		salasService.eliminarSala(id);
	}
	
}