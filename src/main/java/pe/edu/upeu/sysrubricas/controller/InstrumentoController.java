package pe.edu.upeu.sysrubricas.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.sysrubricas.entity.Instrumento;
import pe.edu.upeu.sysrubricas.service.InstrumentoService;
import pe.edu.upeu.sysrubricas.sql.SqlInstrumento;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/instrumento", produces = MediaType.APPLICATION_JSON_VALUE)
public class InstrumentoController {
    @Autowired
    private InstrumentoService instrumentoService;


    @GetMapping()
    public Map<String, List<Instrumento>> getInstrumentos() {

        Map<String, List<Instrumento>> instrumentos = new HashMap<String, List<Instrumento>>();
        instrumentos.put("instrumentos", instrumentoService.getInstrumentos());
        return instrumentos;

    }

    @GetMapping("/{id}")
    public Map<String, Instrumento> getInstrumento(@PathVariable int id) throws SQLException {
        Map<String, Instrumento> instrumento = new HashMap<>();
        instrumento.put("instrumento", instrumentoService.getInstrumento(id));
        return instrumento;
    }
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public String createInstrumento(@RequestBody SqlInstrumento instrumento) {
        instrumentoService.createInstrumento(instrumento);
        return "Creado";
    }

    @PutMapping("/{id}")
    public String updateInstrumento(@PathVariable int id, @RequestBody SqlInstrumento instrumento) {
        instrumento.setInstrumento_id(id);
        instrumentoService.updateInstrumento(instrumento);
        return "Actualizado";
    }
}