package pe.edu.upeu.sysrubricas.service;

import java.util.Map;

import pe.edu.upeu.sysrubricas.entity.DocenteEvaluadorPersona;

public interface DocenteEvaluadorPersonaService {
	int create(DocenteEvaluadorPersona d);

	int update(DocenteEvaluadorPersona d);

	int delete(int id);

	Map<String, Object> read(int id);

	Map<String, Object> readAll();

	Map<String, Object> readAllDocente();

	Map<String, Object> readAllEvaluadorExterno();

	Map<String, Object> readAllExpertoExterno();

	Map<String, Object> readAllEvaluadorHB();

}
