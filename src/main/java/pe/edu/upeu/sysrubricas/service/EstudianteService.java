package pe.edu.upeu.sysrubricas.service;
import java.util.Map;
import pe.edu.upeu.sysrubricas.entity.Estudiante;
public interface EstudianteService {
	int create(Estudiante e);
	int update(Estudiante e);
	int delete(int id);
	Map<String, Object> read(int id);
	Map<String, Object> readAll();
}