package pe.edu.upeu.sysrubricas.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.upeu.sysrubricas.entity.CompetenciaLinea;
import pe.edu.upeu.sysrubricas.entity.Competencia_Linea;
import pe.edu.upeu.sysrubricas.service.CompetenciaLineaService;
import pe.edu.upeu.sysrubricas.service.Competencia_LineaService;

@CrossOrigin(origins = "*", allowedHeaders = "*")


@RestController
@RequestMapping(value = "/api/competencia_lineas", produces = MediaType.APPLICATION_JSON_VALUE)
public class Competencia_LineaController {

	@Autowired
	private Competencia_LineaService competencia_lineaService;


	@GetMapping("/all")
	public List<Map<String, Object>> readAll() {
		return competencia_lineaService.readAll();
	}
	@PostMapping("/add")
	public int create(@RequestBody Competencia_Linea cl) {
		return competencia_lineaService.create(cl);
	}
	@PutMapping("/update/{id}")
	public int update(@RequestBody Competencia_Linea cl, @PathVariable int id) {
		return competencia_lineaService.update(cl);
	}
	@DeleteMapping("/delete/{id}")
	public int delete(@PathVariable int id) {
		return competencia_lineaService.delete(id);
	}
	@GetMapping("/{id}")
	public Map<String, Object> read(@PathVariable int id) {
		return competencia_lineaService.read(id);
	}


}

