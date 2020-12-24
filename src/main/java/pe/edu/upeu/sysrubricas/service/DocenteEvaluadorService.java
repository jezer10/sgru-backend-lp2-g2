package pe.edu.upeu.sysrubricas.service;

import java.util.Map;

import pe.edu.upeu.sysrubricas.entity.DocenteEvaluador;

public interface DocenteEvaluadorService {
	void create(DocenteEvaluador docenteEvaluador);

	void update(DocenteEvaluador docenteEvaluador);

	int delete(int id);

	Map<String, Object> read(int id);

	Map<String, Object> readAll();
}
