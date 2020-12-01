package pe.edu.upeu.sysrubricas.dao;

import java.util.List;
import java.util.Map;

import pe.edu.upeu.sysrubricas.entity.Plan_curso;

public interface Plan_cursoDao {
	int create(Plan_curso pc);
	int update(Plan_curso pc);
	int delete(int id);
	Map<String, Object> read(int id);
	Map<String, Object> readAll();
	List<Map<String, Object>> list();
}
