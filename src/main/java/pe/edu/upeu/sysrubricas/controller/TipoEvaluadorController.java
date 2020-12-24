package pe.edu.upeu.sysrubricas.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.upeu.sysrubricas.service.TipoEvaluadorService;

@RestController
@RequestMapping("/api/tipoevaluador")
public class TipoEvaluadorController {
	@Autowired
	private TipoEvaluadorService tipoEvaluadorService;
	
	@GetMapping("/all")
	private Map<String, Object> readALl(){
		return  tipoEvaluadorService.readAll();
	}
	
}
