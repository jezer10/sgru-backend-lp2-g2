package pe.edu.upeu.sysrubricas.dao;
import java.util.List;
import java.util.Map;
import pe.edu.upeu.sysrubricas.entity.Linea_Plan;
public interface Linea_PlanDao {
	int create(Linea_Plan l);
	int update(Linea_Plan l);
	int delete(int id);
	Map<String,Object>read(int id);
	Map<String,Object>readAll();
	List<Map<String,Object>>list();
}