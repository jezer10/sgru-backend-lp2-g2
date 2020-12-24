package pe.edu.upeu.sysrubricas.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.upeu.sysrubricas.service.EstadoCivilService;

@RestController
@RequestMapping("/api/estadocivil")
public class EstadoCivilController {
	@Autowired
	private EstadoCivilService estadoCivilService;
	@GetMapping("/all")
	Map<String, Object> readAll(){
		return estadoCivilService.readAll();
	}
}
