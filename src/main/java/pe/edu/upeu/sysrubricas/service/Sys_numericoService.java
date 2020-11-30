package pe.edu.upeu.sysrubricas.service;

import java.util.Map;

import pe.edu.upeu.sysrubricas.entity.Sys_numerico;

public interface Sys_numericoService {
	int create(Sys_numerico snum);
    int update(Sys_numerico snum);
    int delete(int id);
    Map<String, Object> read(int id);
    Map<String, Object> readAll();
    
}
