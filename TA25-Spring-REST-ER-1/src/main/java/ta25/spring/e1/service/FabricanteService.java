package ta25.spring.e1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ta25.spring.e1.dao.FabricanteDAO;
import ta25.spring.e1.dto.Fabricante;

@Service
public class FabricanteService {
	@Autowired
	FabricanteDAO fabricanteDAO;
	
	public List<Fabricante> listFabricantes() {
		return fabricanteDAO.findAll();
	}

	public Fabricante saveFabricante(Fabricante fabricante) {
		return fabricanteDAO.save(fabricante);
	}

	public Fabricante FabricanteById(Long id) {
		return fabricanteDAO.findById(id).get();
	}

	public Fabricante updateFabricante(Fabricante fabricante) {
		return fabricanteDAO.save(fabricante);
	}

	public void deleteFabricante(Long id) {
		fabricanteDAO.deleteById(id);
	}
}
