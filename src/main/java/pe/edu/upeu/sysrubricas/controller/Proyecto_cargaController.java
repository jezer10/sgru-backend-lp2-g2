package pe.edu.upeu.sysrubricas.controller;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.upeu.sysrubricas.entity.Proyecto_carga;
import pe.edu.upeu.sysrubricas.service.Proyecto_cargaService;

@RestController
@RequestMapping("/api/cursopy")
public class Proyecto_cargaController {
	
	@Autowired
	Proyecto_cargaService proyecto_cargaService;
	
	@GetMapping("/lista")
	public Map<String, List<Proyecto_carga>> cur(){
		Map<String, List<Proyecto_carga>> cur= new Hashtable<>();
		cur.put("c", proyecto_cargaService.Cursopy());
		return cur;
	}

}
