package pe.edu.upeu.sysrubricas.dao;

import java.util.Map;

import pe.edu.upeu.sysrubricas.entity.Evaluacion;

public interface EvaluacionDao {
	int create(Evaluacion eva);
    int update(Evaluacion eva);
    int delete(int id);
    Map<String, Object> read(int id);
    Map<String, Object> readAll();

}
