package pe.edu.upeu.sysrubricas.service;

import java.util.Map;

public interface Unidad_AcademicaService {
	Map<String,Object> read(int id);//un map es un arrai que trajaba con una llave(string) y un objeto
	Map<String,Object>readAll();
}

