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

import pe.edu.upeu.sysrubricas.entity.NivelRubrica;
import pe.edu.upeu.sysrubricas.service.Nivel_Rubrica_Service;

@RestController
@CrossOrigin(origins = "http://localhost:4200")//// permite el acceso al angular
@RequestMapping("api/nivel_rubrica")

public class Nivel_RubricaController {
	@Autowired	
	private Nivel_Rubrica_Service nivel_Rubrica_Service;

	@PostMapping("/add")
	public int create(@RequestBody NivelRubrica nr) {
		return nivel_Rubrica_Service.create(nr);
	}
	@PutMapping("/update/{id}")
	public int update(@RequestBody NivelRubrica nr,@PathVariable int id) {
		nr.setNivel_rubrica_id(id);
			return nivel_Rubrica_Service.update(nr);
	}
	@DeleteMapping("/delete/{id}")
	public int delete(@PathVariable int id) {
		return nivel_Rubrica_Service.delete(id);
	}
	@GetMapping("/{id}")
	public Map<String, Object> read(@PathVariable int id) {
		try {
		return nivel_Rubrica_Service.read(id);
		}catch (Exception e){
			// TODO: handle exception
						System.out.println("error");
						return null;
		}
	}
	@GetMapping("/all")
	public Map<String, Object> readAll() {
		return nivel_Rubrica_Service.readAll();
	}
	
}

