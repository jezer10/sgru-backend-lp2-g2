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

import pe.edu.upeu.sysrubricas.entity.Competencias;
import pe.edu.upeu.sysrubricas.service.CompetenciaService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")//// permite el acceso al angular
@RequestMapping("api/competencias")

public class CompetenciaController { 
	@Autowired	
	private CompetenciaService competenciaservice;
	
	@PostMapping("/add")
	//este metodo permite registrar una nueva competencia
	public int create(@RequestBody Competencias c) {
		return competenciaservice.create(c);		
	}
	@PutMapping("/update/{id}")
	//este metodo permite modificar una competencia
    public int update(@RequestBody Competencias c,@PathVariable int id) {
		c.setCompetencias_id(id);
	return competenciaservice.update(c);
	}	
	//este metodo permite eliminar una competencia por id
	@DeleteMapping("/delete/{id}")
	//este metodo permite eliminar una competencia
	public int delete(@PathVariable int id) {
		return competenciaservice.delete(id);
	}	
	
	//este metodo permite buscar una competencia por id
		@GetMapping("/{id}")
		public Map<String, Object> read(@PathVariable int id) {
			try {
			return competenciaservice.read(id);
			}catch (Exception e){
				// TODO: handle exception
							System.out.println("error");
							return null;
			}
		}
	@GetMapping("/all")
	public Map<String, Object> readAll(){
		return competenciaservice.readAll();
	}

}
