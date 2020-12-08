package pe.edu.upeu.sysrubricas.dao;
import java.util.List;
import java.util.Map;
import pe.edu.upeu.sysrubricas.entity.LineaPA;
public interface LineaPADao {
	int create(LineaPA l);
	int update(LineaPA l);
	int delete(int id);
	Map<String,Object>read(int id);
	Map<String,Object>readAll();
	List<Map<String,Object>>list();
}