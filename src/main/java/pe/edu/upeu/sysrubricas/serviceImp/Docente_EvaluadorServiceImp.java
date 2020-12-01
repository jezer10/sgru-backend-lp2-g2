package pe.edu.upeu.sysrubricas.serviceImp;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.sysrubricas.dao.Docente_EvaluadorDao;
import pe.edu.upeu.sysrubricas.entity.Docente_Evaluador;
import pe.edu.upeu.sysrubricas.service.Docente_EvaluadorService;

@Service
public class Docente_EvaluadorServiceImp implements Docente_EvaluadorService{

	@Autowired
	private Docente_EvaluadorDao docente_evaluadorDao;
	
	@Override
	public int create(Docente_Evaluador de) {
		// TODO Auto-generated method stub
		return docente_evaluadorDao.create(de);
	}

	@Override
	public int update(Docente_Evaluador de) {
		// TODO Auto-generated method stub
		System.out.println("service: "+de.getGrado_academico());
		System.out.println("service: "+de.getCorreo_trabajo());
		return docente_evaluadorDao.update(de);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return docente_evaluadorDao.delete(id);
	}

	@Override
	public Map<String, Object> read(int id) {
		// TODO Auto-generated method stub
		return docente_evaluadorDao.read(id);
	}

	@Override
	public Map<String, Object> readAll() {
		// TODO Auto-generated method stub
		return docente_evaluadorDao.readAll();
	}

}
