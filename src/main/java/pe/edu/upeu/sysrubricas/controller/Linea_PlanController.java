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
import pe.edu.upeu.sysrubricas.entity.Linea_Plan;
import pe.edu.upeu.sysrubricas.service.Linea_PlanService;
@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RequestMapping("/lineaplan")
public class Linea_PlanController {
	@Autowired
	private Linea_PlanService linea_PlanService;
	@PostMapping("/add")
	private int create(@RequestBody Linea_Plan l) {
		return linea_PlanService.create(l);
	}
	@DeleteMapping("/delete/{id}")
	public int delete(@PathVariable int id) {
		return linea_PlanService.delete(id);
	}
	@GetMapping("/all")
	public Map<String,Object>readAll(){
		return linea_PlanService.readAll();
	}
	@GetMapping("/{id}")
	public Map<String, Object>read(@PathVariable int id){
		return linea_PlanService.read(id);
	}
	@GetMapping("/test")
	public List<Map<String,Object>>list(){
		return linea_PlanService.list();
	}
	@PutMapping("/update/{id}")
	public int update(@RequestBody Linea_Plan l,@PathVariable int id){
		l.setLinea_plan_id(id);
		return linea_PlanService.update(l);
	}
}