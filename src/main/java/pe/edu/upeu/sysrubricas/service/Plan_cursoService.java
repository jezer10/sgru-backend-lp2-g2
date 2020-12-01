package pe.edu.upeu.sysrubricas.service;

import java.util.List;
import java.util.Map;

import pe.edu.upeu.sysrubricas.entity.Plan_curso;

public interface Plan_cursoService {
	int create(Plan_curso pc);
	int update(Plan_curso pc);
	int delete(int id);
	Map<String, Object> read(int id);
	Map<String, Object> readAll();
	List<Map<String, Object>> list();
}
