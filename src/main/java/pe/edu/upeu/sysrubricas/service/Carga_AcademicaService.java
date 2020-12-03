package pe.edu.upeu.sysrubricas.service;

import java.util.Map;

import pe.edu.upeu.sysrubricas.entity.Carga_Academica;

public interface Carga_AcademicaService {

	int create(Carga_Academica ca);
	int update(Carga_Academica ca);
	int delete(int id);
	Map<String, Object> read(int id);
	Map<String, Object> readAll();
}
