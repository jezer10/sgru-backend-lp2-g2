package pe.edu.upeu.sysrubricas.service;

import java.util.Map;

import pe.edu.upeu.sysrubricas.entity.Avance_py;

public interface Avance_pyService {
	int create(Avance_py apy);
    int update(Avance_py apy);
    int delete(int id);
    Map<String, Object> read(int id);
    Map<String, Object> readAll();

}
