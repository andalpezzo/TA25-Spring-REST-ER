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

import ta25.spring.e3.dto.Almacenes;
import ta25.spring.e3.service.AlmacenesService;

@RestController
@RequestMapping("/api")
public class AlmacenesController {
	
	@Autowired
	AlmacenesService almacenesService;
	
	@GetMapping("/almacenes")
	public List<Almacenes> listarAlmacenes(){
		return almacenesService.listarAlmacenes();
	}
	
	@PostMapping("/almacenes")
	public Almacenes salvarAlmacenes(@RequestBody Almacenes departamento) {
		
		return almacenesService.guardarAlmacenes(departamento);
	}
	
	@GetMapping("/almacenes/{id}")
	public Almacenes almacenXID(@PathVariable(name="id") Long id) {
		
		Almacenes almacen_xid = new Almacenes();
		
		almacen_xid = almacenesService.almacenXID(id);
		
		System.out.println("Cliente XID: " + almacen_xid);
		
		return almacen_xid;
	}
	
	@PutMapping("/almacenes/{id}")
	public Almacenes actualizarAlmacen(@PathVariable(name="id")Long id,@RequestBody Almacenes almacen) {
		
		Almacenes almacen_seleccionado= new Almacenes();
		Almacenes almacen_actualizado= new Almacenes();
		
		almacen_seleccionado= almacenesService.almacenXID(id);
		
		almacen_seleccionado.setLugar(almacen.getLugar());
		almacen_seleccionado.setCapacidad(almacen.getCapacidad());
		
		almacen_actualizado = almacenesService.actualizarAlmacen(almacen_seleccionado);
		
		System.out.println("El departamento actualizado es: "+ almacen_actualizado);
		
		return almacen_actualizado;
	}
	
	@DeleteMapping("/almacenes/{id}")
	public void eleiminarAlmacen(@PathVariable(name="id")Long id) {
		almacenesService.eliminarAlmacen(id);
	}
}