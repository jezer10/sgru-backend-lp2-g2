package pe.edu.upeu.sysrubricas.serviceImp;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.sysrubricas.dao.Carga_AcademicaDao;
import pe.edu.upeu.sysrubricas.entity.Carga_Academica;
import pe.edu.upeu.sysrubricas.service.Carga_AcademicaService;

@Service
public class Carga_AcademicaServiceImp implements Carga_AcademicaService{

	@Autowired
	private Carga_AcademicaDao carga_academicaDao;
	
	@Override
	public int create(Carga_Academica ca) {
		// TODO Auto-generated method stub
		return carga_academicaDao.create(ca);
	}

	@Override
	public int update(Carga_Academica ca) {
		// TODO Auto-generated method stub
		return carga_academicaDao.update(ca);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return carga_academicaDao.delete(id);
	}

	@Override
	public Map<String, Object> read(int id) {
		// TODO Auto-generated method stub
		return carga_academicaDao.read(id);
	}

	@Override
	public Map<String, Object> readAll() {
		// TODO Auto-generated method stub
		return carga_academicaDao.readAll();
	}	
}
