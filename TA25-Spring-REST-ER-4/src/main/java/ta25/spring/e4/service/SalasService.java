package ta25.spring.e4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ta25.spring.e4.dao.SalasDAO;
import ta25.spring.e4.dto.Salas;

@Service
public class SalasService {

	@Autowired
	SalasDAO SalasDAO;

	public List<Salas> listarSalas() {

		return SalasDAO.findAll();
	}

	public Salas guardarSala(Salas sala) {

		return SalasDAO.save(sala);
	}

	public Salas salaXID(long codigo) {

		return SalasDAO.findById(codigo).get();
	}

	public Salas actualizarSala(Salas sala) {

		return SalasDAO.save(sala);
	}

	public void eliminarSala(long codigo) {

		SalasDAO.findById(codigo);
	}
}