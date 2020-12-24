package pe.edu.upeu.sysrubricas.dao;

import java.util.Map;


public interface TipoEvaluadorDao {
//	int create(TipoEvaluador t);
//
//	int update(TipoEvaluador t);
//
//	int delete(int id);

	Map<String, Object> read(int id);

	Map<String, Object> readAll();
	


}
