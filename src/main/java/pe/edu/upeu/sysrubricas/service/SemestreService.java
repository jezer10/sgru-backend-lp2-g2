package pe.edu.upeu.sysrubricas.service;

import java.util.Map;

import pe.edu.upeu.sysrubricas.entity.Semestre;

public interface SemestreService {
	int create(Semestre s);
	int update(Semestre s);
	int delete(int id);
	Map<String,Object> read(int id);
	Map<String,Object>readAll();
}
