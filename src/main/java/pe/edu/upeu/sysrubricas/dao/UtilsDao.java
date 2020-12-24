package pe.edu.upeu.sysrubricas.dao;

import java.util.Map;

public interface UtilsDao {
	Map<String,Object> readAllCiclo();
	Map<String,Object> readAllGrupo();
	Map<String,Object> readAllTipoIns();
	Map<String,Object> readAllNCD();
	Map<String,Object> readAllNivComp();
	Map<String,Object> readAllNivLog();


}
