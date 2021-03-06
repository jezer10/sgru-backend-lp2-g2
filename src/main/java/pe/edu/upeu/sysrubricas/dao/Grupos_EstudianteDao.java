package pe.edu.upeu.sysrubricas.dao;
import java.util.List;
import java.util.Map;
import pe.edu.upeu.sysrubricas.entity.Grupos_Estudiante;
public interface Grupos_EstudianteDao {
	int create(Grupos_Estudiante ge);
	int update(Grupos_Estudiante ge);
	int delete(int id);
	Map<String,Object>read(int id);
	Map<String,Object>readAll();
	List<Map<String,Object>>list();
}