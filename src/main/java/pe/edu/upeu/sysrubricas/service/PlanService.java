package pe.edu.upeu.sysrubricas.service;

import java.util.Map;

import pe.edu.upeu.sysrubricas.entity.Plan;

public interface PlanService {
	int create(Plan p);
	int update(Plan p);
	int delete(int id);
	Map<String, Object> read(int id);
	Map<String, Object> readAll();
	Map<String, Object> readCampus();
	Map<String, Object> readFacultad(int id1);
	Map<String, Object> readPA(int id2);
	Map<String, Object> readAll2();
}
