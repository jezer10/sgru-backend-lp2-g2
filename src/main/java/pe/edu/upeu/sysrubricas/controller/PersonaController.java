package pe.edu.upeu.sysrubricas.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.upeu.sysrubricas.service.PersonaService;

@RestController
@RequestMapping("/persona")
public class PersonaController {
	@Autowired
	private PersonaService personaService;
	@GetMapping("/all")
	public List<Map<String, Object>> readAll(){
		return personaService.readAll();
	}
}
