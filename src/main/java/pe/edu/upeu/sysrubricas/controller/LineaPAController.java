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
import pe.edu.upeu.sysrubricas.entity.LineaPA;
import pe.edu.upeu.sysrubricas.service.LineaPAService;
@RestController
@RequestMapping("/lineapa")
public class LineaPAController {
	@Autowired
	private LineaPAService lineaPAService;
	@PostMapping("/add")
	private int create(@RequestBody LineaPA l) {
		return lineaPAService.create(l);
	}
	@DeleteMapping("/delete/{id}")
	public int delete(@PathVariable int id) {
		return lineaPAService.delete(id);
	}
	@GetMapping("/all")
	public Map<String,Object>readAll(){
		return lineaPAService.readAll();
	}
	@GetMapping("/{id}")
	public Map<String,Object>read(@PathVariable int id){
		return lineaPAService.read(id);
	}
	@GetMapping("/test")
	public List<Map<String,Object>>list(){
		return lineaPAService.list();
	}
	@PutMapping("/update/{id}")
	public int update(@RequestBody LineaPA l,@PathVariable int id) {
		l.setLineas_pa_id(id);
		return lineaPAService.update(l);
	}
}