package pe.edu.upeu.sysrubricas.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	@GetMapping("/")
	public String saludo() {
		return "HOLA MUNDO";
	}
}
