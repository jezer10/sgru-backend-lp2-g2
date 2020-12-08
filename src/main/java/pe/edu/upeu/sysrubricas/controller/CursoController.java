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

import pe.edu.upeu.sysrubricas.entity.Curso;
import pe.edu.upeu.sysrubricas.service.CursoService;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RequestMapping("/api/cursos")
public class CursoController {
	@Autowired
	private CursoService cursoService;

	@PostMapping("/add")
	public int create(@RequestBody Curso c) {
		return cursoService.create(c);

	}
	@DeleteMapping("/delete/{id}")
	public int delete(@PathVariable int id ) {
		return cursoService.delete(id);
	}

	@GetMapping("/all")
	public Map<String, Object> readAll() {
		return cursoService.readAll();
	}

	@GetMapping("/{id}")
	public Map<String, Object> read(@PathVariable int id) {
		return cursoService.read(id);
	}

	@PutMapping("/update/{id}")
	public int update(@RequestBody Curso c, @PathVariable int id) {
		c.setCurso_id(id);
		return cursoService.update(c);
	}
}
