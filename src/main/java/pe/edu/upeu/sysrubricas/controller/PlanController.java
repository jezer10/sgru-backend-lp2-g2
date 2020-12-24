package pe.edu.upeu.sysrubricas.controller;

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

import pe.edu.upeu.sysrubricas.entity.Plan;
import pe.edu.upeu.sysrubricas.service.PlanService;

@RestController
@RequestMapping("/api/planes")
public class PlanController {
	@Autowired
	private PlanService planService;
	
	@PostMapping("/add")
	public int create(@RequestBody Plan p) {
		return planService.create(p);
	}
	
	@DeleteMapping("/delete/{id}")
	public int delete(@PathVariable int id ) {
		return planService.delete(id);
	}

	@GetMapping("/all")
	public Map<String, Object> readAll() {
		return planService.readAll();
	}

	@GetMapping("/{id}")
	public Map<String, Object> read(@PathVariable int id) {
		return planService.read(id);
	}
	@GetMapping("/all2")
	public Map<String, Object> readAll2() {
		return planService.readAll2();
	}
	@GetMapping("/campus")
	public Map<String, Object> readCampus() {
		return planService.readCampus();
	}
	@GetMapping("/facultad/{id}")
	public Map<String, Object> readFacultad(@PathVariable int id) {
		return planService.readFacultad(id);
	}
	@GetMapping("/pa/{id}")
	public Map<String, Object> readPA(@PathVariable int id) {
		return planService.readPA(id);
	}
	@PutMapping("/update/{id}")
	public int update(@RequestBody Plan p, @PathVariable int id) {
		p.setPlan_id(id);
		return planService.update(p);
	}
	
}
