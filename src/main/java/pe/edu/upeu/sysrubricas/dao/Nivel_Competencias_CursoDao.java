package pe.edu.upeu.sysrubricas.dao;
import java.util.Map;

import pe.edu.upeu.sysrubricas.entity.Nivel_Competencias_Curso;

public interface Nivel_Competencias_CursoDao {
	int create(Nivel_Competencias_Curso ncc);
	int update(Nivel_Competencias_Curso ncc);
	int delete(int id);
	Map<String, Object> read(int id);
	Map<String, Object> readAll();
	Map<String, Object> readCurso();
	Map<String, Object> readPlan();
	Map<String, Object> readAll2();
	Map<String, Object> readCiclo();
	Map<String, Object> readTipo_comp();
	Map<String, Object> readLinea();
	Map<String, Object> readCompetencia();
	Map<String, Object> readNivel();
}
