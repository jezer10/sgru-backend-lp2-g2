package pe.edu.upeu.sysrubricas.controller;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.upeu.sysrubricas.entity.Indicador;
import pe.edu.upeu.sysrubricas.service.Indicador_Service;

@RestController
@CrossOrigin(origins = "http://localhost:4200")//// permite el acceso al angular
@RequestMapping("api/indicador")

public class IndicadorController {
	@Autowired
	private Indicador_Service indicador_Service;
	
	@PostMapping("/add")
	public int create(@RequestBody Indicador i) {
		return indicador_Service.create(i);
	}
	@PutMapping("/update/{id}")
	public int update(@RequestBody Indicador i,@PathVariable int id) {
		i.setIndicador_id(id);
		return indicador_Service.update(i);
	}
	@DeleteMapping("/delete/{id}")
	public int delete(@PathVariable int id) {
		return indicador_Service.delete(id);
	}
	@GetMapping("/{id}")
	public Map<String, Object> read(@PathVariable int id) {
		try {
		return indicador_Service.read(id);
		}catch (Exception e){
			// TODO: handle exception
						System.out.println("error");
						return null;
		}
	}
	@GetMapping("/all")
	public Map<String, Object> readAll() {
		return indicador_Service.readAll();
	}
	
}
