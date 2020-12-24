package pe.edu.upeu.sysrubricas.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.upeu.sysrubricas.service.UtilsService;

@RestController
@RequestMapping("/utils/all")
public class UtilsController {
	@Autowired
	private UtilsService utilsService;

	@GetMapping("/ciclo")
	Map<String, Object> readAllCiclo() {
		return utilsService.readAllCiclo();
	}

	@GetMapping("/grupo")
	Map<String, Object> readAllGrupo() {
		return utilsService.readAllGrupo();
	};

	@GetMapping("/tipoins")
	Map<String, Object> readAllTipoIns() {
		return utilsService.readAllTipoIns();
	};

	@GetMapping("/ncd")
	Map<String, Object> readAllNCD() {
		return utilsService.readAllNCD();
	}

	@GetMapping("/nivcomp")
	Map<String, Object> readAllNivComp() {
		return utilsService.readAllNivComp();
	}

	@GetMapping("/nivlog")
	Map<String, Object> readAllNivLog() {
		return utilsService.readAllNivLog();
	}

}
