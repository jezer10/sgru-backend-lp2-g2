package pe.edu.upeu.sysrubricas.serviceImp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.sysrubricas.dao.Tipo_CompetenciaDao;
import pe.edu.upeu.sysrubricas.service.Tipo_CompetenciaService;
@Service

public class Tipo_CompetenciaServiceImpl implements Tipo_CompetenciaService{
@Autowired
private Tipo_CompetenciaDao tipo_CompetenciaDao;

@Override
public List<Map<String, Object>> readAll() {
	// TODO Auto-generated method stub
	return tipo_CompetenciaDao.readAll();
}

@Override
public Map<String, Object> read(int id) {
	// TODO Auto-generated method stub
	return tipo_CompetenciaDao.read(id);
}






}

