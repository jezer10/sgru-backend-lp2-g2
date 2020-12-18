package pe.edu.upeu.sysrubricas.service;

import java.util.Map;

import pe.edu.upeu.sysrubricas.entity.NivelRubrica;


public interface Nivel_Rubrica_Service {
	int create(NivelRubrica nr);
	int update(NivelRubrica nr);
	int delete(int id);
	Map<String,Object> read(int id);//un map es un arrai que trajaba con una llave(string) y un objeto
	Map<String,Object>readAll();
}
