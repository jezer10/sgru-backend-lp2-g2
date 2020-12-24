package pe.edu.upeu.sysrubricas.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.upeu.sysrubricas.dao.Tipo_CompetenciaDao;
import pe.edu.upeu.sysrubricas.service.Tipo_CompetenciaService;

@RestController
@CrossOrigin(origins = "*")//// permite el acceso al angular
@RequestMapping("api/tipo_competencia")


public class Tipo_CompetenciaController {
	@Autowired
	private Tipo_CompetenciaService tipoCompetenciaService;
	@GetMapping("/all")
	public List<Map<String,Object>> readAll() {
		return tipoCompetenciaService.readAll();
	}
	@GetMapping("/{id}")
	public Map<String, Object> read(@PathVariable int id) {
		try {
		return tipoCompetenciaService.read(id);
		}catch (Exception e){
			// TODO: handle exception
						System.out.println("error");
						return null;
		}
	}
	
}
