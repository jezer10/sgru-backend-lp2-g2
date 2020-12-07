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

import pe.edu.upeu.sysrubricas.entity.Semestre;
import pe.edu.upeu.sysrubricas.service.SemestreService;



@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api/semestre")
public class SemestreController {
	@Autowired	
	private SemestreService semestreservice;
	
	@GetMapping("/all")

	public Map<String, Object> read() {
		
			return semestreservice.readAll();
		}

	
	@GetMapping("/{id}")

	public Map<String, Object> read(@PathVariable int id) {
		return semestreservice.read(id);
		
		}
	
	@DeleteMapping("/delete/{id}")

	public int delete(@PathVariable int id) {
		return semestreservice.delete(id);
	}	
	@PostMapping("/create")

	public int create(@RequestBody Semestre s) {
		return semestreservice.create(s);	
		
	}
	@PutMapping("/update/{id}")

	public int update(@RequestBody Semestre s, @PathVariable int id) {
		s.setSemestre_id(id);
		return semestreservice.update(s);
	
	
	}	
	
}

