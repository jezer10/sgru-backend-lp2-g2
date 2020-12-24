package pe.edu.upeu.sysrubricas.controller;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.upeu.sysrubricas.entity.Curso;
import pe.edu.upeu.sysrubricas.service.CursoService;

@RestController
@RequestMapping("/api/curso")
@CrossOrigin(origins = "*")
public class CursoController {
	@Autowired
	CursoService cursoService;
	
	@GetMapping
	public Map<String, List<Curso>> cur(){
		Map<String, List<Curso>> cur= new Hashtable<>();
		cur.put("c", cursoService.Cursopy());
		return cur;
	}


}
