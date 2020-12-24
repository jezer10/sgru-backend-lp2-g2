package pe.edu.upeu.sysrubricas.service;

import java.util.Map;

import pe.edu.upeu.sysrubricas.entity.Nivel_logro;

public interface Nivel_logroService {

	int create(Nivel_logro l);
	int update(Nivel_logro l);
	int delete(int id);
	Map<String,Object> read(int id);
	Map<String,Object>readAll();	
}
