package pe.edu.upeu.sysrubricas.dao;


import java.util.Map;


import pe.edu.upeu.sysrubricas.entity.Persona;


public interface PersonaDao {
	void create(Persona p);

	void update(Persona p);

	int delete(int id);

	Persona read(int id);

	Map<String, Object> readAll();
}
