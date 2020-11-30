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

import pe.edu.upeu.sysrubricas.entity.Evaluacion;
import pe.edu.upeu.sysrubricas.service.EvaluacionService;

@RestController
@RequestMapping("/evaluacion")
public class EvaluacionController {
	
	@Autowired
	private EvaluacionService evaluacionService;
	
	@GetMapping("/lista")
    public Map<String,Object> listar(){
        return evaluacionService.readAll();
    }
    @GetMapping("/{id}")
    public Map<String,Object> read(@PathVariable int id) {
        return evaluacionService.read(id);
    }
    @DeleteMapping("/delete/{id}")
    public int delete(@PathVariable int id) {
        return evaluacionService.delete(id);
    }
    @PostMapping("/persona")
    public int create (@RequestBody Evaluacion evaluacion) {
        return evaluacionService.create(evaluacion);
    }
    @PutMapping("edit/{id}")
    public int update(@RequestBody Evaluacion evaluacion,@PathVariable int id) {
    	evaluacion.setEvaluacion_id(id);
        return evaluacionService.update(evaluacion);
    }

}
