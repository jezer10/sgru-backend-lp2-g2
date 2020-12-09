package pe.edu.upeu.sysrubricas.service;
import java.util.List;
import java.util.Map;
import pe.edu.upeu.sysrubricas.entity.Proyecto_Integrador;
public interface Proyecto_IntegradorService {
	int create(Proyecto_Integrador py);
	int update(Proyecto_Integrador py);
	int delete(int id);
	Map<String,Object>read(int id);
	Map<String,Object>readAll();
	List<Map<String,Object>>list();
}