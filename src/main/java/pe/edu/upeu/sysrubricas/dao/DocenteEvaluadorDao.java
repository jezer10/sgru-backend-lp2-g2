package pe.edu.upeu.sysrubricas.dao;

import java.util.Map;

import pe.edu.upeu.sysrubricas.entity.DocenteEvaluador;

public interface DocenteEvaluadorDao {
	void create(DocenteEvaluador docenteEvaluador);

	void update(DocenteEvaluador docenteEvaluador);

	int delete(int id);

	Map<String, Object> read(int id);

	Map<String, Object> readAll();
}
