package pe.edu.upeu.sysrubricas.controller;


import java.util.List;
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

import pe.edu.upeu.sysrubricas.entity.Nivel_Competencias_Curso;
import pe.edu.upeu.sysrubricas.service.Nivel_Competencias_CursoService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")//// permite el acceso al angular
@RequestMapping("api/nivel_competencias_curso")

public class Nivel_Competencias_CursoController { 
	@Autowired	
	private Nivel_Competencias_CursoService nivel_competencias_cursoService;
	@PostMapping("/add")
	public int create(@RequestBody Nivel_Competencias_Curso ncc, @PathVariable int id) {
		return nivel_competencias_cursoService.create(ncc);
	}
	@PutMapping("/update/{id}")
	public int update(Nivel_Competencias_Curso ncc) {
		return nivel_competencias_cursoService.update(ncc);
	}
	@DeleteMapping("/delete/{id}")
	public int delete(@PathVariable int id) {
		return nivel_competencias_cursoService.delete(id);
	}
	@GetMapping("/{id}")
	public Map<String, Object> read(@PathVariable int id) {
		return nivel_competencias_cursoService.read(id);
	}
	@GetMapping("/all")
	public List<Map<String, Object>> readAll() {
		return nivel_competencias_cursoService.readAll();
	}

	
	
}
