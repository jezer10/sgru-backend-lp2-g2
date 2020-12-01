package pe.edu.upeu.sysrubricas.dao;
import java.util.Map;
import pe.edu.upeu.sysrubricas.entity.Tipo_Evaluador;
public interface Tipo_EvaluadorDao {
	int create (Tipo_Evaluador te);
	int update (Tipo_Evaluador te);
	int delete (int id);
	Map<String, Object> read(int id);
	Map<String, Object> readAll();
}