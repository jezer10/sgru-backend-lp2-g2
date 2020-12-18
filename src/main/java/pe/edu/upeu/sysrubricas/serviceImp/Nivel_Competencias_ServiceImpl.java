package pe.edu.upeu.sysrubricas.serviceImp;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.sysrubricas.dao.Nivel_CompetenciaDao;
import pe.edu.upeu.sysrubricas.entity.Nivel_Competencias;
import pe.edu.upeu.sysrubricas.service.Nivel_Competencias_Service;

@Service

public class Nivel_Competencias_ServiceImpl implements Nivel_Competencias_Service{
	@Autowired
	public Nivel_CompetenciaDao nivel_competenciaDao;

	@Override
	public int create(Nivel_Competencias nc) {
		// TODO Auto-generated method stub
		return nivel_competenciaDao.create(nc);
	}

	@Override
	public int update(Nivel_Competencias nc) {
		// TODO Auto-generated method stub
		return nivel_competenciaDao.update(nc);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return nivel_competenciaDao.delete(id);
	}

	@Override
	public Map<String, Object> read(int id) {
		// TODO Auto-generated method stub
		return nivel_competenciaDao.read(id);
	}

	@Override
	public List<Map<String, Object>> readAll() {
		// TODO Auto-generated method stub
		return nivel_competenciaDao.readAll();
	}

	

	
}

