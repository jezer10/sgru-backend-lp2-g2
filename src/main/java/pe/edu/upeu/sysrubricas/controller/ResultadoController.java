package pe.edu.upeu.sysrubricas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.sysrubricas.entity.Conf_evaluacion;
import pe.edu.upeu.sysrubricas.entity.Conf_py;
import pe.edu.upeu.sysrubricas.entity.Estudiante;
import pe.edu.upeu.sysrubricas.service.ResultadoService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", allowedHeaders = "*")

@RestController
@RequestMapping(value = "/api/resultado", produces = MediaType.APPLICATION_JSON_VALUE)
public class ResultadoController {
    @Autowired
    private ResultadoService resultadoService;

    @GetMapping("/estudiante")
    public Map<String, List<Estudiante>> getEstudiante(){
        Map<String, List<Estudiante>> estudiantes = new HashMap<>();
        estudiantes.put("estudiantes", resultadoService.getEstudiante());
        return estudiantes;
    }
    @GetMapping("{nombre}")
    public Map<String,List<Conf_py>> getConf_py(@PathVariable String nombre){
        Map<String,List<Conf_py>> conf_py = new HashMap<>();
        conf_py.put("conf_py",resultadoService.getConf_py(nombre));
        return conf_py;
    }
    @GetMapping("conf_eva/{id}")
    public Map<String,List<Conf_evaluacion>> getConf_eva(@PathVariable int id){
        Map<String,List<Conf_evaluacion>> conf_eva = new HashMap<>();
        conf_eva.put("conf_eva",resultadoService.getConf_evaluacion(id));
        return conf_eva;
    }
}
