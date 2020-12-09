package pe.edu.upeu.sysrubricas.controller;
import java.util.List;
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
import pe.edu.upeu.sysrubricas.entity.Py_Grupos;
import pe.edu.upeu.sysrubricas.service.Py_GruposService;
@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RequestMapping("/pygrupos")
public class Py_GruposController {
	@Autowired
	private Py_GruposService py_GruposService;
	@PostMapping("/add")
	private int create(@RequestBody Py_Grupos p) {
		return py_GruposService.create(p);
	}
	@DeleteMapping("/delete/{id}")
	public int delete(@PathVariable int id) {
		return py_GruposService.delete(id);
	}
	@GetMapping("/all")
	public Map<String,Object>readAll(){
		return py_GruposService.readAll();
	}
	@GetMapping("/{id}")
	public Map<String, Object>read(@PathVariable int id){
		return py_GruposService.read(id);
	}
	@GetMapping("/test")
	public List<Map<String,Object>>list(){
		return py_GruposService.list();
	}
	@PutMapping("/update/{id}")
	public int update(@RequestBody Py_Grupos p,@PathVariable int id) {
		p.setPy_grupo_id(id);
		return py_GruposService.update(p);
	}
}