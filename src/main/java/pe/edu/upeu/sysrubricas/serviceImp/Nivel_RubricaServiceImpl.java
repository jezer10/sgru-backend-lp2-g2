package pe.edu.upeu.sysrubricas.serviceImp;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.sysrubricas.dao.Nivel_RubricaDao;
import pe.edu.upeu.sysrubricas.entity.NivelRubrica;
import pe.edu.upeu.sysrubricas.service.Nivel_Rubrica_Service;

@Service

public class Nivel_RubricaServiceImpl implements Nivel_Rubrica_Service {
	@Autowired
	public Nivel_RubricaDao nivel_RubricaDao;

	@Override
	public int create(NivelRubrica nr) {
		// TODO Auto-generated method stub
		return nivel_RubricaDao.create(nr);
	}

	@Override
	public int update(NivelRubrica nr) {
		// TODO Auto-generated method stub
		return nivel_RubricaDao.update(nr);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return nivel_RubricaDao.delete(id);
	}

	@Override
	public Map<String, Object> read(int id) {
		// TODO Auto-generated method stub
		return nivel_RubricaDao.read(id);
	}

	@Override
	public Map<String, Object> readAll() {
		// TODO Auto-generated method stub
		return nivel_RubricaDao.readAll();
	}
}
