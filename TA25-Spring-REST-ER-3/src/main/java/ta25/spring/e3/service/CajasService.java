package ta25.spring.e3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ta25.spring.e3.dao.CajasDAO;
import ta25.spring.e3.dto.Cajas;

@Service
public class CajasService {
	@Autowired
	CajasDAO cajasDAO;

	public List<Cajas> listarCajas() {

		return cajasDAO.findAll();
	}

	public Cajas guardarCajas(Cajas caja) {

		return cajasDAO.save(caja);
	}

	public Cajas cajaXID(Long numRef) {

		return cajasDAO.findById(numRef).get();
	}

	public Cajas actualizarCaja(Cajas caja) {

		return cajasDAO.save(caja);
	}

	public void eliminarCaja(Long numRef) {

		cajasDAO.findById(numRef);

	}
}