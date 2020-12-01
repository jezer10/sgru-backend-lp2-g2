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
import pe.edu.upeu.sysrubricas.entity.Docente_Evaluador;
import pe.edu.upeu.sysrubricas.service.Docente_EvaluadorService;
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/docentevaluador")
public class Docente_EvaluadorController {
	@Autowired
	private Docente_EvaluadorService docente_evaluadorService;
	@GetMapping("/all")
	public Map<String, Object> read(@PathVariable int id){
		try {
			return docente_evaluadorService.read(id);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error");
			return null;
		}
	}
	@DeleteMapping("/delete{id}")
	public int delete(@PathVariable int id) {
		return docente_evaluadorService.delete(id);
	}
	@PostMapping("/add")
	public int create(@RequestBody Docente_Evaluador de) {
		return docente_evaluadorService.create(de);
	}
	@PutMapping("/update/{id}")
	public int update(@RequestBody Docente_Evaluador de, @PathVariable int id) {
		de.setPersona_id(id);
		return docente_evaluadorService.update(de);
	}
}