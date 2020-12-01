package pe.edu.upeu.sysrubricas.service;
import java.util.Map;
import pe.edu.upeu.sysrubricas.entity.Docente_Evaluador;
public interface Docente_EvaluadorService {
	int create(Docente_Evaluador de);
	int update(Docente_Evaluador de);
	int delete(int id);
	Map<String, Object> read(int id);
	Map<String, Object> readAll();
}