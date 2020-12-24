package pe.edu.upeu.sysrubricas.dao;

import java.util.Map;

public interface InformeDao {
	Map<String,Object> readInformeGeneral(int ua_id,int semestre_id);
	Map<String,Object> readInformeIndividual(int ua_id,int semestre_id,int utils_id);
	Map<String,Object> readAllInformeUAC();
	Map<String, Object> readAllInformeUAF(int id);
	Map<String, Object> readAllInformeUAPA(int id);


}
