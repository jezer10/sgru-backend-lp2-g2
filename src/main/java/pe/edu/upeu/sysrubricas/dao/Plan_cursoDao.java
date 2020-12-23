package pe.edu.upeu.sysrubricas.dao;

import java.util.Map;

import pe.edu.upeu.sysrubricas.entity.Plan_curso;

public interface Plan_cursoDao {
	int create(Plan_curso pc);
	int update(Plan_curso pc);
	int delete(int id);
	Map<String, Object> read(int id);
	Map<String, Object> readAll();
	Map<String, Object> readCurso();
	Map<String, Object> readPlan();
	Map<String, Object> readAll2();
	Map<String, Object> readCiclo();
	Map<String, Object> readCampus();
	Map<String, Object> readFacultad(int id1);
	Map<String, Object> readPA(int id2);
	Map<String, Object> readPlan2(int id3);
}
