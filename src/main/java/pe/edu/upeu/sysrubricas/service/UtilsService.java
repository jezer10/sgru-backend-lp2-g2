package pe.edu.upeu.sysrubricas.service;

import java.util.Map;

import pe.edu.upeu.sysrubricas.entity.Utils;

public interface UtilsService {
	int create(Utils u);
	int update(Utils u);
	int delete(int id);
	Map<String,Object> read(int id);
	Map<String,Object>readAll();

}
