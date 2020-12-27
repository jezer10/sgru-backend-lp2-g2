package pe.edu.upeu.sysrubricas.dao;

import java.util.List;
import java.util.Map;

import pe.edu.upeu.sysrubricas.entity.Acceso;


public interface AccesoDao {
	int create(Acceso a);
	int update(Acceso a);
	int update(int id);
	int delete(int id);
	List<Map<String, Object>> read(int id);
	List<Map<String, Object>> readAll();
	Map<String,Object> readAllSubMains(int id);
	Map<String, Object> readAll(String username);

	List<Acceso> getAccesosbyid(int id);
}
