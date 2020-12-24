package pe.edu.upeu.sysrubricas.service;

import java.util.List;
import java.util.Map;

public interface Tipo_CompetenciaService {
	Map<String,Object> read(int id);
	List<Map<String, Object>>readAll();
}
