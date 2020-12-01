package pe.edu.upeu.sysrubricas.serviceImp;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.sysrubricas.dao.Tipo_EvaluadorDao;
import pe.edu.upeu.sysrubricas.entity.Tipo_Evaluador;
import pe.edu.upeu.sysrubricas.service.Tipo_EvaluadorService;

@Service
public class Tipo_EvaluadorServiceImp implements Tipo_EvaluadorService{

	@Autowired
	private Tipo_EvaluadorDao tipo_EvaluadorDao;
	
	@Override
	public int create(Tipo_Evaluador te) {
		// TODO Auto-generated method stub
		return tipo_EvaluadorDao.create(te);
	}

	@Override
	public int update(Tipo_Evaluador te) {
		// TODO Auto-generated method stub
		System.out.println("service: "+te.getNombre());
		return tipo_EvaluadorDao.update(te);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return tipo_EvaluadorDao.delete(id);
	}

	@Override
	public Map<String, Object> read(int id) {
		// TODO Auto-generated method stub
		return tipo_EvaluadorDao.read(id);
	}

	@Override
	public Map<String, Object> readAll() {
		// TODO Auto-generated method stub
		return tipo_EvaluadorDao.readAll();
	}

}
