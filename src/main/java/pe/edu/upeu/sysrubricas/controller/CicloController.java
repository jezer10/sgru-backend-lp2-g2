package pe.edu.upeu.sysrubricas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.sysrubricas.entity.Ciclo;
import pe.edu.upeu.sysrubricas.service.CicloService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", allowedHeaders = "*")


@RestController
@RequestMapping(value = "/api/ciclo", produces = MediaType.APPLICATION_JSON_VALUE)
public class CicloController {

    @Autowired
    private CicloService cicloService;

    @GetMapping("{id}")
    public Map<String, List<Ciclo>> getCiclos(@PathVariable int id){
        Map<String, List<Ciclo>> ciclos = new HashMap<>();
        ciclos.put("ciclos",cicloService.getCiclos(id));
        return ciclos;
    }
}
