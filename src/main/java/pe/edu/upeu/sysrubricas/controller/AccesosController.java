package pe.edu.upeu.sysrubricas.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.upeu.sysrubricas.dao.AccesoDao;


@RestController
@RequestMapping("api/acceso")
public class AccesosController {
	@Autowired
	private AccesoDao accesoDao;
	@GetMapping(value = "/submain/{id}")
	public Map<String,Object> getMethodName(@PathVariable int id) {
		return accesoDao.readAllSubMains(id);
	}

}
