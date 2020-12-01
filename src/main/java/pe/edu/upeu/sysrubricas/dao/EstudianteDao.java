package pe.edu.upeu.sysrubricas.dao;
import java.util.Map;
import pe.edu.upeu.sysrubricas.entity.Estudiante;
public interface EstudianteDao {
	int create(Estudiante e);
	int update(Estudiante e);
	int delete(int id);
	Map<String, Object> read(int id);
	Map<String, Object> readAll();
}