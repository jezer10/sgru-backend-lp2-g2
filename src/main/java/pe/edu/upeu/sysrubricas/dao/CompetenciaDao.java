package pe.edu.upeu.sysrubricas.dao;

import java.util.Map;

import pe.edu.upeu.sysrubricas.entity.Competencias;

public interface CompetenciaDao {
	int create(Competencias c);
	int update(Competencias c);
	int delete(int id);
	Map<String,Object> read(int id);//un map es un arrai que trajaba con una llave(string) y un objeto
	Map<String,Object>readAll();
	String prueba(String texto);
	
	
}
