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
import pe.edu.upeu.sysrubricas.entity.Proyecto_Integrador;
import pe.edu.upeu.sysrubricas.service.Proyecto_IntegradorService;
@RestController
@RequestMapping("/py")
public class Proyecto_IntegradorController {
	@Autowired
	private Proyecto_IntegradorService proyecto_IntegradorService;
	@PostMapping("/add")
	private int create(@RequestBody Proyecto_Integrador py) {
		return proyecto_IntegradorService.create(py);
	}
	@DeleteMapping("/delete/{id}")
	public int delete(@PathVariable int id) {
		return proyecto_IntegradorService.delete(id);
	}
	@GetMapping("/all")
	public Map<String,Object>readAll(){
		return proyecto_IntegradorService.readAll();
	}
	@GetMapping("/{id}")
	public Map<String,Object>read(@PathVariable int id){
		return proyecto_IntegradorService.read(id);
	}
	@GetMapping("/test")
	public List<Map<String,Object>>list(){
		return proyecto_IntegradorService.list();
	}
	@PutMapping("/update/{id}")
	public int update(@RequestBody Proyecto_Integrador py,@PathVariable int id) {
		py.setPy_id(id);
		return proyecto_IntegradorService.update(py);
	}
}