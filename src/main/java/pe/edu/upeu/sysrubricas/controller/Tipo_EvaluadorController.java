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
import pe.edu.upeu.sysrubricas.entity.Tipo_Evaluador;
import pe.edu.upeu.sysrubricas.service.Tipo_EvaluadorService;
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/tipoevaluador")
public class Tipo_EvaluadorController {
	@Autowired
	private Tipo_EvaluadorService tipo_evaluadorService;
	@GetMapping("/all")
	public Map<String, Object> lista(){
		return tipo_evaluadorService.readAll();
	}
	@GetMapping("/{id}")
	public Map<String, Object> read(@PathVariable int id){
		try {
			return tipo_evaluadorService.read(id);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("error");
			return null;
		}
	}
	@DeleteMapping("/delete/{id}")
	public int delete(@PathVariable int id) {
		return tipo_evaluadorService.delete(id);
	}
	@PostMapping("/add")
	public int create(@RequestBody Tipo_Evaluador te) {
		return tipo_evaluadorService.create(te);
	}
	@PutMapping("/update/{id}")
	public int update(@RequestBody Tipo_Evaluador te, @PathVariable int id) {
		te.setTipo_evaluador_id(id);
		return tipo_evaluadorService.update(te);
	}
}