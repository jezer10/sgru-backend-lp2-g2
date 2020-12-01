package pe.edu.upeu.sysrubricas.service;

import java.util.List;
import java.util.Map;

import pe.edu.upeu.sysrubricas.entity.Curso;

public interface CursoService {
	int create(Curso c);
	int update(Curso c);
	int delete(int id);
	Map<String, Object> read(int id);
	Map<String, Object> readAll();
	List<Map<String, Object>> list();
}
