package ta25.spring.e3.controller;

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

import ta25.spring.e3.dto.Cajas;
import ta25.spring.e3.service.CajasService;

@RestController
@RequestMapping("/api")
public class CajasController {

	@Autowired
	CajasService CajasService;
	
	@GetMapping("/cajas")
	public List<Cajas> listarVideos(){
		return CajasService.listarCajas();
	}
	
	@PostMapping("/cajas")
	public Cajas salvarArticulo(@RequestBody Cajas caja) {
		
		return CajasService.guardarCajas(caja);
	}
	
	@GetMapping("/cajas/{id}")
	public Cajas articuloXID(@PathVariable(name="id") Long numRef) {
		
		Cajas caja_xid= new Cajas();
		
		caja_xid=CajasService.cajaXID(numRef);
		
		System.out.println("Video XID: "+caja_xid);
		
		return caja_xid;
	}
	
	@PutMapping("/cajas/{id}")
	public Cajas actualizarArticulo(@PathVariable(name="id")Long numRef,@RequestBody Cajas caja) {
		
		Cajas caja_seleccionada= new Cajas();
		Cajas caja_actualizada= new Cajas();
		
		caja_seleccionada= CajasService.cajaXID(numRef);
		
		caja_seleccionada.setContenido(caja.getContenido());
		caja_seleccionada.setValor(caja.getValor());
		caja_seleccionada.setAlmacen(caja.getAlmacen());
		
		caja_actualizada = CajasService.actualizarCaja(caja_seleccionada);
		
		System.out.println("La caja actualizada es: "+ caja_actualizada);
		
		return caja_actualizada;
	}
	
	@DeleteMapping("/cajas/{id}")
	public void eliminarArticulo(@PathVariable(name="id")Long numRef) {
		CajasService.eliminarCaja(numRef);
	}
}