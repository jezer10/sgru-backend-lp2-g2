package pe.edu.upeu.sysrubricas.dao;

import java.util.List;
import java.util.Map;

import pe.edu.upeu.sysrubricas.entity.Plan;

public interface PlanDao {
	int create(Plan p);
	int update(Plan p);
	int delete(int id);
	Map<String, Object> read(int id);
	Map<String, Object> readAll();
	List<Map<String, Object>> list();
}
