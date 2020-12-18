package pe.edu.upeu.sysrubricas.serviceImp;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.sysrubricas.dao.Unidad_AcademicaDao;
import pe.edu.upeu.sysrubricas.service.Unidad_AcademicaService;

@Service

public class Unidad_AcademicaServiceImpl implements Unidad_AcademicaService{
	@Autowired
	public Unidad_AcademicaDao unidad_AcademicaDao;
	
	@Override
	public Map<String, Object> read(int id) {
		// TODO Auto-generated method stub
		return unidad_AcademicaDao.read(id);
	}

	@Override
	public Map<String, Object> readAll() {
		// TODO Auto-generated method stub
		return unidad_AcademicaDao.readAll();
	}

}
