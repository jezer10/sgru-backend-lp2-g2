package pe.edu.upeu.sysrubricas.controller;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upeu.sysrubricas.entity.Grupos_Estudiante;
import pe.edu.upeu.sysrubricas.service.Grupos_EstudianteService;
@RestController
@RequestMapping("/grupoest")
public class Grupos_EstudianteController {
	@Autowired
	private Grupos_EstudianteService grupos_EstudianteService;
	@PostMapping("/add")
	private int create(@RequestBody Grupos_Estudiante ge) {
		return grupos_EstudianteService.create(ge);
	}
	@DeleteMapping("/delete/{id}")
	public int delete(@PathVariable int id) {
		return grupos_EstudianteService.delete(id);
	}
	@GetMapping("/all")
	public Map<String,Object>readAll(){
		return grupos_EstudianteService.readAll();
	}
	@GetMapping("/{id}")
	public Map<String,Object>read(@PathVariable int id){
		return grupos_EstudianteService.read(id);
	}
	@GetMapping("/test")
	public List<Map<String,Object>>list(){
		return grupos_EstudianteService.list();
	}
	@PutMapping("/update/{id}")
	public int update(@RequestBody Grupos_Estudiante ge,@PathVariable int id) {
		ge.setGr_es_id(id);
		return grupos_EstudianteService.update(ge);
	}
}