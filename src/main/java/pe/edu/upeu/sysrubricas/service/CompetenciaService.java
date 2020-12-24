package pe.edu.upeu.sysrubricas.service;

import java.util.Map;

import pe.edu.upeu.sysrubricas.entity.Competencias;

public interface CompetenciaService {
	int create(Competencias c);
	int update(Competencias c);
	int delete(int id);
	Map<String,Object> read(int id);
	Map<String,Object>readAll();
}

