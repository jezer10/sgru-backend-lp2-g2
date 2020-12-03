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

import pe.edu.upeu.sysrubricas.entity.Carga_Academica;
import pe.edu.upeu.sysrubricas.service.Carga_AcademicaService;

@RestController
@CrossOrigin (origins ="*", allowedHeaders = "*")
@RequestMapping("/carga_academicas")
public class Carga_AcademicaController {

	@Autowired
	private Carga_AcademicaService carga_academicaService;
	
	@GetMapping("/all")
	public Map<String, Object> read(@PathVariable int id){
		try {
			return carga_academicaService.read(id);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error");
			return null;
		}
	}
	
	@DeleteMapping("/delete{id}")
	public int delete(@PathVariable int id) {
		return carga_academicaService.delete(id);
	}
	
	@PostMapping("/add")
	public int create(@RequestBody Carga_Academica ca) {
		return carga_academicaService.create(ca);
	}
	
	@PutMapping("/update/{id}")
	public int update(@RequestBody Carga_Academica ca, @PathVariable int id) {
		ca.setPersona_id(id);
		return carga_academicaService.update(ca);
	}
}
