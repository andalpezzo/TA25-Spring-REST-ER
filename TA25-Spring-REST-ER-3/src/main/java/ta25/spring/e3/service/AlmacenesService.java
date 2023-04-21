package ta25.spring.e3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ta25.spring.e3.dao.AlmacenesDAO;
import ta25.spring.e3.dto.Almacenes;

@Service
public class AlmacenesService {

	@Autowired
	AlmacenesDAO almacenesDAO;
	
	public List<Almacenes> listarAlmacenes() {
		
		return almacenesDAO.findAll();
	}

	public Almacenes guardarAlmacenes(Almacenes almacen) {
		
		return almacenesDAO.save(almacen);
	}

	public Almacenes almacenXID(Long id) {
		
		return almacenesDAO.findById(id).get();
	}
	
	public Almacenes actualizarAlmacen(Almacenes almacen) {
		
		return almacenesDAO.save(almacen);
	}
	
	public void eliminarAlmacen(Long id) {
		
		almacenesDAO.deleteById(id);
		
	}
}