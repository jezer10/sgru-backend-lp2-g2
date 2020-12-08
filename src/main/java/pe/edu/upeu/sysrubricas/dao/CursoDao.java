package pe.edu.upeu.sysrubricas.dao;

import java.util.Map;

import pe.edu.upeu.sysrubricas.entity.Curso;

public interface CursoDao {
	int create(Curso c);
	int update(Curso c);
	int delete(int id);
	Map<String, Object> read(int id);
	Map<String, Object> readAll();
}
