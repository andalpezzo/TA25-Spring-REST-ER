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

import ta25.spring.e4.dto.Peliculas;
import ta25.spring.e4.service.PeliculasService;

@RestController
@RequestMapping("/api")
public class PeliculasController {
	
	@Autowired
	PeliculasService peliculasService;
	
	@GetMapping("/peliculas")
	public List<Peliculas> listarAlmacenes(){
		return peliculasService.listarPeliculas();
	}
	
	@PostMapping("/peliculas")
	public Peliculas salvarAlmacenes(@RequestBody Peliculas departamento) {
		
		return peliculasService.guardarPelicula(departamento);
	}
	
	@GetMapping("/peliculas/{id}")
	public Peliculas almacenXID(@PathVariable(name="id") Long id) {
		
		Peliculas pelicula_xid = new Peliculas();
		
		pelicula_xid = peliculasService.peliculaXID(id);
		
		System.out.println("Pelicula XID: " + pelicula_xid);
		
		return pelicula_xid;
	}
	
	@PutMapping("/peliculas/{id}")
	public Peliculas actualizarAlmacen(@PathVariable(name="id")Long id,@RequestBody Peliculas pelicula) {
		
		Peliculas pelicula_seleccionada= new Peliculas();
		Peliculas pelicula_actualizada= new Peliculas();
		
		pelicula_seleccionada= peliculasService.peliculaXID(id);
		
		pelicula_seleccionada.setNombre(pelicula.getNombre());
		pelicula_seleccionada.setCalificacionedad(pelicula.getCalificacionEdad());
		
		pelicula_actualizada = peliculasService.actualizarPelicula(pelicula_seleccionada);
		
		System.out.println("La pelicula actualizada es: "+ pelicula_actualizada);
		
		return pelicula_actualizada;
	}
	
	@DeleteMapping("/peliculas/{id}")
	public void eleiminarAlmacen(@PathVariable(name="id")Long id) {
		peliculasService.eliminarPelicula(id);
	}

}