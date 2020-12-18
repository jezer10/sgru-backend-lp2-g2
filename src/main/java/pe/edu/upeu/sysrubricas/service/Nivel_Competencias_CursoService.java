package pe.edu.upeu.sysrubricas.service;

import java.util.List;
import java.util.Map;

import pe.edu.upeu.sysrubricas.entity.Nivel_Competencias_Curso;

public interface Nivel_Competencias_CursoService {
	int create(Nivel_Competencias_Curso ncc);
	int update(Nivel_Competencias_Curso ncc);
	int delete(int id);
	Map<String,Object> read(int id);//un map es un arrai que trajaba con una llave(string) y un objeto
	List<Map<String, Object>>readAll();
	
}
