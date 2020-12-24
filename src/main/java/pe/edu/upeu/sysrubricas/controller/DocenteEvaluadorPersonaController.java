package pe.edu.upeu.sysrubricas.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.upeu.sysrubricas.entity.DocenteEvaluadorPersona;
import pe.edu.upeu.sysrubricas.service.DocenteEvaluadorPersonaService;
@RestController
@RequestMapping("/api/evaluador")
public class DocenteEvaluadorPersonaController {
	@Autowired
	private DocenteEvaluadorPersonaService docenteEvaluadorPersonaService;
	@GetMapping("/{id}")
	Map<String, Object> read(@PathVariable int id){
		return docenteEvaluadorPersonaService.read(id);
	}
	@GetMapping("/all")
	Map<String,Object> readAll(){
		return docenteEvaluadorPersonaService.readAll();
	}
	@GetMapping("/docente/all")
	Map<String,Object> readAllDocente(){
		return docenteEvaluadorPersonaService.readAllDocente();
	}
	@GetMapping("/externo/all")
	Map<String,Object> readAllEvaluadorExterno(){
		return docenteEvaluadorPersonaService.readAllEvaluadorExterno();
	}
	@GetMapping("/experto/all")
	Map<String,Object> readallExpertoExterno(){
		return docenteEvaluadorPersonaService.readAllExpertoExterno();
	}
	@GetMapping("/habilidad/all")
	Map<String,Object> readAllEvaluadorHB(){
		return docenteEvaluadorPersonaService.readAllEvaluadorHB();
	}
	@DeleteMapping("/delete/{id}")
	private int delete(@PathVariable int id) {
		return docenteEvaluadorPersonaService.delete(id);
	}
	@PutMapping("/update/{id}")
	private int update(@RequestBody DocenteEvaluadorPersona d,@PathVariable int id) {
		d.setPersona_id(id);
		return docenteEvaluadorPersonaService.update(d);
	}
	@PostMapping("/create")
	private int create(@RequestBody DocenteEvaluadorPersona d) {
		return docenteEvaluadorPersonaService.create(d);
	}
	
}
