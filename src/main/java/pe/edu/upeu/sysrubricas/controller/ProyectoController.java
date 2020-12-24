package pe.edu.upeu.sysrubricas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.sysrubricas.entity.*;
import pe.edu.upeu.sysrubricas.service.ProyectoService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping(value = "/api/proyecto", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProyectoController {
    @Autowired
    private ProyectoService proyectoService;




    @GetMapping("/{id}")
    public Map<String, List<Proyecto>> getProyectos(@PathVariable int id){
        Map<String,List<Proyecto>> proyectos = new HashMap<>();
        proyectos.put("proyectos",proyectoService.getProyecto(id));
        return proyectos;
    }

    @GetMapping("union/{id}")
    public ArrayList<Object> getUnion(@PathVariable int id){
        Map<String,List<Proyecto>> proyecto = new HashMap<>();
        Map<String,List<Curso>> cursos = new HashMap<>();
        proyecto.put("proyecto",proyectoService.comoBuscar(id));
        cursos.put("cursos",proyectoService.getCursosxPy(id));
        ArrayList<Object> loba = new ArrayList<>();
        loba.add(proyecto);
        loba.add(cursos);


        return  loba;
    }


    @GetMapping("/curso/{id}")
    public Map<String,List<Curso>> getCursos(@PathVariable int id){
        Map<String,List<Curso>> cursos = new HashMap<>();
        cursos.put("cursos",proyectoService.getCursosxPy(id));
        return cursos;
    }
}
