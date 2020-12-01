package pe.edu.upeu.sysrubricas.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upeu.sysrubricas.entity.Estudiante;
import pe.edu.upeu.sysrubricas.service.EstudianteService;
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/estudiante")
public class EstudianteController {
	@Autowired
	private EstudianteService estudianteService;
	@GetMapping("/all")
	public Map<String, Object> lista(){
		return estudianteService.readAll();
	}
	@GetMapping("/{id}")
	public Map<String, Object> read(@PathVariable int id){
		try {
			return estudianteService.read(id);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error");
			return null;
		}
	}
	@DeleteMapping("/delete/{id}")
	public int delete(@PathVariable int id) {
		return estudianteService.delete(id);
	}
	@PostMapping("/add")
	public int create(@RequestBody Estudiante e) {
		return estudianteService.create(e);
	}	
	@PutMapping("/update/id")
	public int update(@RequestBody Estudiante e, @PathVariable int id) {
		e.setPersona_id(id);
		return estudianteService.update(e);
	}
}