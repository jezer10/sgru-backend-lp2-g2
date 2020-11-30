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

import pe.edu.upeu.sysrubricas.entity.Sys_numerico;
import pe.edu.upeu.sysrubricas.service.Sys_numericoService;

@RestController
@RequestMapping("/numerico")
public class Sys_numericoController {
	
	@Autowired
	private Sys_numericoService sys_numericoService;
	
	@GetMapping("/lista")
    public Map<String,Object> listar(){
        return sys_numericoService.readAll();
    }
    @GetMapping("/{id}")
    public Map<String,Object> read(@PathVariable int id) {
        return sys_numericoService.read(id);
    }
    @DeleteMapping("/delete/{id}")
    public int delete(@PathVariable int id) {
        return sys_numericoService.delete(id);
    }
    @PostMapping("/persona")
    public int create (@RequestBody Sys_numerico sys_nuemrico) {
        return sys_numericoService.create(sys_nuemrico);
    }
    @PutMapping("edit/{id}")
    public int update(@RequestBody Sys_numerico sys_numerico,@PathVariable int id) {
    	sys_numerico.setSys_numerico_id(id);
        return sys_numericoService.update(sys_numerico);
    }
}
