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

import pe.edu.upeu.sysrubricas.entity.Avance_py;
import pe.edu.upeu.sysrubricas.service.Avance_pyService;

@RestController
@RequestMapping("/api/avance_py")
@CrossOrigin(origins = "*")
public class Avance_pyController {
	
	@Autowired
	private Avance_pyService avance_pyService;
	
	@GetMapping("/lista")
    public Map<String,Object> listar(){
        return avance_pyService.readAll();
    }
    @GetMapping("/{id}")
    public Map<String,Object> read(@PathVariable int id) {
        return avance_pyService.read(id);
    }
    @DeleteMapping("/delete/{id}")
    public int delete(@PathVariable int id) {
        return avance_pyService.delete(id);
    }
    @PostMapping("/add")
    public int create (@RequestBody Avance_py avance_py) {
        return avance_pyService.create(avance_py);
    }
    @PutMapping("/edit/{id}")
    public int update(@RequestBody Avance_py avance_py,@PathVariable int id) {
    	avance_py.setAvance_py_id(id);
        return avance_pyService.update(avance_py);
    }

}
