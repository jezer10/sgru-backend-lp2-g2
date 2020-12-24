package pe.edu.upeu.sysrubricas.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.upeu.sysrubricas.service.TipoDocumentoService;

@RestController
@RequestMapping("/api/tipodoc")
public class TipoDocumentoController {
	@Autowired
	private TipoDocumentoService tipoDocumentoService;
	@GetMapping("/all")
	Map<String, Object> readAll(){
		return tipoDocumentoService.readAll();
	}
}
