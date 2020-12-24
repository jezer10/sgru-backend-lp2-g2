package pe.edu.upeu.sysrubricas.serviceImp;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.sysrubricas.dao.Avance_pyDao;
import pe.edu.upeu.sysrubricas.entity.Avance_py;
import pe.edu.upeu.sysrubricas.service.Avance_pyService;

@Service
public class Avance_pyServiceImp implements Avance_pyService {
	
	@Autowired
	private Avance_pyDao avance_pyDao;

	@Override
	public int create(Avance_py apy) {
		// TODO Auto-generated method stub
		return avance_pyDao.create(apy);
	}

	@Override
	public int update(Avance_py apy) {
		// TODO Auto-generated method stub
		return avance_pyDao.update(apy);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return avance_pyDao.delete(id);
	}

	@Override
	public Map<String, Object> read(int id) {
		// TODO Auto-generated method stub
		return avance_pyDao.read(id);
	}

	@Override
	public Map<String, Object> readAll() {
		// TODO Auto-generated method stub
		return avance_pyDao.readAll();
	}

}
