package pe.edu.upeu.sysrubricas.service;

import java.util.List;
import java.util.Map;

import pe.edu.upeu.sysrubricas.entity.Nivel_Competencias;

public interface Nivel_Competencias_Service {
	int create(Nivel_Competencias nc);
	int update(Nivel_Competencias nc);
	int delete(int id);
	Map<String,Object> read(int id);//un map es un arrai que trajaba con una llave(string) y un objeto
	List<Map<String, Object>>readAll();
}

