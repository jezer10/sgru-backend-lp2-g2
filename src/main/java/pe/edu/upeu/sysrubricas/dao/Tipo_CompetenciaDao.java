package pe.edu.upeu.sysrubricas.dao;

import java.util.List;
import java.util.Map;

import pe.edu.upeu.sysrubricas.entity.Tipo_Competencia;

public interface Tipo_CompetenciaDao {
	Map<String,Object> read(int id);
	List<Map<String, Object>>readAll();
	
}

