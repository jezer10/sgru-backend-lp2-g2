package pe.edu.upeu.sysrubricas.serviceImp;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.sysrubricas.dao.DocenteEvaluadorPersonaDao;
import pe.edu.upeu.sysrubricas.entity.DocenteEvaluadorPersona;
import pe.edu.upeu.sysrubricas.service.DocenteEvaluadorPersonaService;
@Service
public class DocenteEvaluadorPersonaServiceImp implements DocenteEvaluadorPersonaService{
	@Autowired
	private DocenteEvaluadorPersonaDao docenteEvaluadorPersonaDao;
	@Override
	public int create(DocenteEvaluadorPersona d) {
		// TODO Auto-generated method stub
		return docenteEvaluadorPersonaDao.create(d);
	}

	@Override
	public int update(DocenteEvaluadorPersona d) {
		// TODO Auto-generated method stub
		return docenteEvaluadorPersonaDao.update(d);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return docenteEvaluadorPersonaDao.delete(id);
	}

	@Override
	public Map<String, Object> read(int id) {
		return docenteEvaluadorPersonaDao.read(id);
	}


	@Override
	public Map<String, Object> readAllDocente() {
		// TODO Auto-generated method stub
		return docenteEvaluadorPersonaDao.readAllDocente();
	}

	@Override
	public Map<String, Object> readAllEvaluadorExterno() {
		// TODO Auto-generated method stub
		return docenteEvaluadorPersonaDao.readAllEvaluadorExterno();
	}

	@Override
	public Map<String, Object> readAllExpertoExterno() {
		// TODO Auto-generated method stub
		return docenteEvaluadorPersonaDao.readAllExpertoExterno();
	}

	@Override
	public Map<String, Object> readAllEvaluadorHB() {
		// TODO Auto-generated method stub
		return docenteEvaluadorPersonaDao.readAllEvaluadorHB();
	}

	@Override
	public Map<String, Object> readAll() {
		// TODO Auto-generated method stub
		return docenteEvaluadorPersonaDao.readAll();
	}

}
