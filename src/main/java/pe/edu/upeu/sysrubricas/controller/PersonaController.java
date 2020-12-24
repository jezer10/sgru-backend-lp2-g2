package pe.edu.upeu.sysrubricas.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.upeu.sysrubricas.entity.Persona;
import pe.edu.upeu.sysrubricas.service.PersonaService;

@RestController
@RequestMapping("/persona")
public class PersonaController {
	@Autowired
	private PersonaService personaService;
	@GetMapping("/all")
	public Map<String, Object> readAll(){
		return personaService.readAll();
	}
	@GetMapping("/{id}")
	public Persona read(@PathVariable int id){
		return personaService.read(id);
	}
	@DeleteMapping("/delete/{id}")
	public int delete(@PathVariable int id) {
		return personaService.delete(id);
	}
}
