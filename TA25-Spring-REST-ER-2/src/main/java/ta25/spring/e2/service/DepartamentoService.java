package ta25.spring.e2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ta25.spring.e2.dao.DepartamentosDAO;
import ta25.spring.e2.dto.Departamentos;

@Service
public class DepartamentoService {
	@Autowired
	DepartamentosDAO departamentosDAO;

	public List<Departamentos> listDepartamentos() {
		return departamentosDAO.findAll();
	}

	public Departamentos saveDepartamento(Departamentos departamentos) {
		return departamentosDAO.save(departamentos);
	}

	public Departamentos DepartamentoById(Long id) {
		return departamentosDAO.findById(id).get();
	}

	public Departamentos updateDepartamento(Departamentos departamentos) {
		return departamentosDAO.save(departamentos);
	}

	public void deleteDepartamento(Long id) {
		departamentosDAO.deleteById(id);
	}
}
