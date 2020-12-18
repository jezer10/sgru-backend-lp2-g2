package pe.edu.upeu.sysrubricas.serviceImp;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.sysrubricas.dao.IndicadorDao;
import pe.edu.upeu.sysrubricas.entity.Indicador;
import pe.edu.upeu.sysrubricas.service.Indicador_Service;
@Service

public class Indicador_ServiceImpl implements Indicador_Service{
	@Autowired
	public IndicadorDao indicadorDao;
	@Override
	public int create(Indicador i) {
		// TODO Auto-generated method stub
		return indicadorDao.create(i);
	}

	@Override
	public int update(Indicador i) {
		// TODO Auto-generated method stub
		return indicadorDao.update(i);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return indicadorDao.delete(id);
	}

	@Override
	public Map<String, Object> read(int id) {
		// TODO Auto-generated method stub
		return indicadorDao.read(id);
	}

	@Override
	public Map<String, Object> readAll() {
		// TODO Auto-generated method stub
		return indicadorDao.readAll();
	}

}

