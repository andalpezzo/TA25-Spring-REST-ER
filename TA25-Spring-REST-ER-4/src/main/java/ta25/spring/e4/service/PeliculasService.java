package ta25.spring.e4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ta25.spring.e4.dao.PeliculasDAO;
import ta25.spring.e4.dto.Peliculas;

@Service
public class PeliculasService {
	@Autowired
	PeliculasDAO peliculasDAO;
	
	public List<Peliculas> listarPeliculas() {
		
		return peliculasDAO.findAll();
	}

	public Peliculas guardarPelicula(Peliculas pelicula) {
		
		return peliculasDAO.save(pelicula);
	}

	public Peliculas peliculaXID(Long id) {
		
		return peliculasDAO.findById(id).get();
	}

	public Peliculas actualizarPelicula(Peliculas pelicula) {
		
		return peliculasDAO.save(pelicula);
	}

	public void eliminarPelicula(Long id) {
		
		peliculasDAO.deleteById(id);
		
	}

}