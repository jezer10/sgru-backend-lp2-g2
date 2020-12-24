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

import pe.edu.upeu.sysrubricas.entity.Nivel_Competencias_Curso;
import pe.edu.upeu.sysrubricas.entity.Semestre;
import pe.edu.upeu.sysrubricas.service.Nivel_Competencias_CursoService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/nivel_competencias_curso")

public class Nivel_Competencias_CursoController {
	@Autowired
	private Nivel_Competencias_CursoService nivel_competencias_cursoService;

	@PostMapping("/create")
	public int create(@RequestBody Nivel_Competencias_Curso ncc) {
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
	public Map<String, Object> readAll() {
		return nivel_competencias_cursoService.readAll();
	}

	@GetMapping("/cur")
	public Map<String, Object> readCurso() {
		return nivel_competencias_cursoService.readCurso();
	}

	@GetMapping("/pl")
	public Map<String, Object> readPlan() {
		return nivel_competencias_cursoService.readPlan();
	}

	@GetMapping("/ci")
	public Map<String, Object> readCiclo() {
		return nivel_competencias_cursoService.readCiclo();
	}

	@GetMapping("/all2")
	public Map<String, Object> readAll2() {
		return nivel_competencias_cursoService.readAll2();
	}

	@GetMapping("/tip")
	public Map<String, Object> readTipo_comp() {
		return nivel_competencias_cursoService.readTipo_comp();
	}

	@GetMapping("/comp")
	public Map<String, Object> readCompetencia() {
		return nivel_competencias_cursoService.readCompetencia();
	}

	@GetMapping("/lin")
	public Map<String, Object> readLinea() {
		return nivel_competencias_cursoService.readLinea();
	}

	@GetMapping("/niv")
	public Map<String, Object> readNivel() {
		return nivel_competencias_cursoService.readNivel();
	}
}
