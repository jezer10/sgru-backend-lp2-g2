package pe.edu.upeu.sysrubricas.service;

import java.util.Map;

public interface TipoEvaluadorService {
//	int create(TipoEvaluador t);
//
//	int update(TipoEvaluador t);
//
//	int delete(int id);

	Map<String, Object> read(int id);

	Map<String, Object> readAll();
}
