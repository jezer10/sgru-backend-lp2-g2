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

import pe.edu.upeu.sysrubricas.entity.Nivel_logro;
import pe.edu.upeu.sysrubricas.service.Nivel_logroService;

@RestController
@CrossOrigin(origins="*", allowedHeaders="*")
@RequestMapping("/logro")
public class Nivel_logroController {
	@Autowired	
	private Nivel_logroService nivel_logroservice;
	
	@GetMapping("/all")

	public Map<String, Object> read() {
		
			return nivel_logroservice.readAll();
		}

	
	@GetMapping("/{id}")

	public Map<String, Object> read(@PathVariable int id) {
		return nivel_logroservice.read(id);
		
		}
	
	@DeleteMapping("/delete/{id}")

	public int delete(@PathVariable int id) {
		return nivel_logroservice.delete(id);
	}	
	@PostMapping("/add")

	public int create(@RequestBody Nivel_logro l) {
		return nivel_logroservice.create(l);	
		
	}
	@PutMapping("/update/{id}")

	public int update(@RequestBody Nivel_logro l, @PathVariable int id) {
		l.setNivel_logro_id(id);
		return nivel_logroservice.update(l);
	
	
	}	
	
}


