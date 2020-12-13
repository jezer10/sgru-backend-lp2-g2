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

import pe.edu.upeu.sysrubricas.entity.Plan_curso;
import pe.edu.upeu.sysrubricas.service.Plan_cursoService;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RequestMapping("/api/planescursos")
public class Plan_cursoController {
	@Autowired
	private Plan_cursoService plan_cursoService;
	@PostMapping("/add")
	public int create(@RequestBody Plan_curso pc) {
		return plan_cursoService.create(pc);

	}
	@DeleteMapping("/delete/{id}")
	public int delete(@PathVariable int id ) {
		return plan_cursoService.delete(id);
	}

	@GetMapping("/all")
	public Map<String, Object> readAll() {
		return plan_cursoService.readAll();
	}
	
	@GetMapping("/all2")
	public Map<String, Object> readAll2() {
		return plan_cursoService.readAll2();
	}
	
	@GetMapping("/{id}")
	public Map<String, Object> read(@PathVariable int id) {
		return plan_cursoService.read(id);
	}

	@PutMapping("/update/{id}")
	public int update(@RequestBody Plan_curso pc, @PathVariable int id) {
		pc.setPlan_curso_id(id);
		return plan_cursoService.update(pc);
	}
	@GetMapping("/cur")
	public Map<String, Object> readCurso() {
		return plan_cursoService.readCurso();
	}
	@GetMapping("/pl")
	public Map<String, Object> readPlan() {
		return plan_cursoService.readPlan();
	}
	@GetMapping("/ci")
	public Map<String, Object> readCiclo() {
		return plan_cursoService.readCiclo();
	}
}
