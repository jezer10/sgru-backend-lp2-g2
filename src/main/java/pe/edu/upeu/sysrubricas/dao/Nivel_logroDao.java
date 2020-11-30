package pe.edu.upeu.sysrubricas.dao;

import java.util.Map;

import pe.edu.upeu.sysrubricas.entity.Nivel_logro;

public interface Nivel_logroDao {
	int create(Nivel_logro l);
	int update(Nivel_logro l);
	int delete(int id);
	Map<String,Object> read(int id);//un map es un arrai que trajaba con una llave(string) y un objeto
	Map<String,Object>readAll();	



}
