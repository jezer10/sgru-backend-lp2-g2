package pe.edu.upeu.sysrubricas.service;


import java.util.Map;

import pe.edu.upeu.sysrubricas.entity.Nivel_Competencias;

public interface Nivel_CompetenciasService {
	int create(Nivel_Competencias nc);
	int update(Nivel_Competencias nc);
	int delete(int id);
	Map<String,Object> read(int id);//un map es un arrai que trajaba con una llave(string) y un objeto
	Map<String, Object>readAll();
	Map<String, Object>readNivelCompetencia();
	Map<String, Object>readCompetencia();
	Map<String, Object>readNivel();
}
