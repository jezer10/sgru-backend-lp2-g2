package pe.edu.upeu.sysrubricas.service;


import java.util.Map;

import pe.edu.upeu.sysrubricas.entity.Persona;
import pe.edu.upeu.sysrubricas.sql.SqlInstrumento;

public interface PersonaService {
	void create(final SqlInstrumento instrumento);

	void update(SqlInstrumento instrumento);

	int delete(int id);

	Persona read(int id);

	Map<String, Object> readAll();
}
