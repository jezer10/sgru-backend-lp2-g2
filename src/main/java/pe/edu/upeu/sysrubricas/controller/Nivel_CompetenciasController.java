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

import pe.edu.upeu.sysrubricas.entity.Nivel_Competencias;
import pe.edu.upeu.sysrubricas.service.Nivel_CompetenciasService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")//// permite el acceso al angular
@RequestMapping("api/nivel_competencias")

public class Nivel_CompetenciasController { 

	@Autowired	
	private Nivel_CompetenciasService nivel_competencias_Service;
	
	@PostMapping("/create")
	public int create(@RequestBody Nivel_Competencias nc) {
		return nivel_competencias_Service.create(nc);
	}
	@PutMapping("/update/{id}")
	public int update(@RequestBody Nivel_Competencias nc,@PathVariable int id) {
		nc.setNivel_competencias_id(id);
		return nivel_competencias_Service.update(nc);
	}
	@DeleteMapping("/delete/{id}")
	public int delete(@PathVariable int id) {
		return nivel_competencias_Service.delete(id);
	}
	@GetMapping("/{id}")
	public Map<String, Object> read(@PathVariable int id) {
		try {
		return nivel_competencias_Service.read(id);
		}catch (Exception e){
			// TODO: handle exception
						System.out.println("error");
						return null;
		}
	}
	@GetMapping("/all")
	public Map<String, Object> readAll() {
		return nivel_competencias_Service.readAll();
	 }

	@GetMapping("/nivcomp")
	public Map<String, Object> readNivelCompetencia() {
		return nivel_competencias_Service.readNivelCompetencia();
	}
	@GetMapping("/comp")
	public Map<String, Object> readCompetencia() {
		return nivel_competencias_Service.readCompetencia();
	}
	@GetMapping("/niv")
	public Map<String, Object> readNivel() {
		return nivel_competencias_Service.readNivel();
	}
	
}