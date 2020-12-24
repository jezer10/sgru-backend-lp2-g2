package pe.edu.upeu.sysrubricas.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.upeu.sysrubricas.service.InformeService;

@RestController
@RequestMapping("/api/informe")
public class InformeController {
	@Autowired
	private InformeService informeService;
	@GetMapping("/{id}/{id2}")
	public Map<String, Object> readInformeGeneral(@PathVariable int id, @PathVariable int id2) {
		// TODO Auto-generated method stub
		return informeService.readInformeGeneral(id, id2);
	}
	
	@GetMapping("/{id}/{id2}/{id3}")
	public Map<String, Object> readInformeIndividual(@PathVariable int id, @PathVariable int id2, @PathVariable int id3) {
		// TODO Auto-generated method stub
		return informeService.readInformeIndividual(id, id2,id3);
	}
	@GetMapping("/uac")
	Map<String,Object> readAllInformeUAC(){
		return informeService.readAllInformeUAC();
		}
	@GetMapping("/uaf/{id}")

	Map<String, Object> readAllInformeUAF(@PathVariable int id){
		return informeService.readAllInformeUAF(id);
		}
	@GetMapping("/uapa/{id}")

	Map<String, Object> readAllInformeUAPA(@PathVariable int id){
		return informeService.readAllInformeUAPA(id);
	}
}
