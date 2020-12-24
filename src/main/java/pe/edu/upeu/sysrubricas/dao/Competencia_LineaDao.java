package pe.edu.upeu.sysrubricas.dao;

import java.util.List;
import java.util.Map;

import pe.edu.upeu.sysrubricas.entity.Competencia_Linea;
import pe.edu.upeu.sysrubricas.entity.Competencias;

public interface Competencia_LineaDao {
	int create (Competencia_Linea cl);
	int update(Competencia_Linea cl);
	int delete(int id);
	Map<String,Object> read(int id);
	List<Map<String, Object>>readAll();

	
	
}
