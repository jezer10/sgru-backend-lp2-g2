package pe.edu.upeu.sysrubricas.serviceImp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.sysrubricas.dao.Grupos_EstudianteDao;
import pe.edu.upeu.sysrubricas.entity.Grupos_Estudiante;
import pe.edu.upeu.sysrubricas.service.Grupos_EstudianteService;
@Service
public class Grupos_EstudianteServiceImp implements Grupos_EstudianteService{
	@Autowired
	private Grupos_EstudianteDao grupos_EstudianteDao;
	@Override
	public int create(Grupos_Estudiante ge) {
		// TODO Auto-generated method stub
		return grupos_EstudianteDao.create(ge);
	}

	@Override
	public int update(Grupos_Estudiante ge) {
		// TODO Auto-generated method stub
		return grupos_EstudianteDao.update(ge);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return grupos_EstudianteDao.delete(id);
	}

	@Override
	public Map<String,Object>read(int id) {
		// TODO Auto-generated method stub
		return grupos_EstudianteDao.read(id);
	}

	@Override
	public Map<String,Object>readAll() {
		// TODO Auto-generated method stub
		return grupos_EstudianteDao.readAll();
	}

	@Override
	public List<Map<String,Object>>list() {
		// TODO Auto-generated method stub
		return grupos_EstudianteDao.list();
	}
	
}