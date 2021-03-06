package pe.edu.upeu.sysrubricas.service;
import java.util.List;
import java.util.Map;
import pe.edu.upeu.sysrubricas.entity.Py_Grupos;
public interface Py_GruposService {
	int create(Py_Grupos p);
	int update(Py_Grupos p);
	int delete(int id);
	Map<String,Object>read(int id);
	Map<String,Object>readAll();
	List<Map<String,Object>>list();
}