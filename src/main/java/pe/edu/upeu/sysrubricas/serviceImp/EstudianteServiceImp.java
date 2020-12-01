package pe.edu.upeu.sysrubricas.serviceImp;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.sysrubricas.dao.EstudianteDao;
import pe.edu.upeu.sysrubricas.entity.Estudiante;
import pe.edu.upeu.sysrubricas.service.EstudianteService;

@Service
public class EstudianteServiceImp implements EstudianteService{

	@Autowired
	private EstudianteDao estudianteDao;
	
	@Override
	public int create(Estudiante e) {
		// TODO Auto-generated method stub
		return estudianteDao.create(e);
	}

	@Override
	public int update(Estudiante e) {
		// TODO Auto-generated method stub
		System.out.println("service: "+e.getCodigo_estudiante());
		System.out.println("service: "+e.getCorreo_insti());
		System.out.println("service: "+e.getEstado());
		return estudianteDao.update(e);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return estudianteDao.delete(id);
	}

	@Override
	public Map<String, Object> read(int id) {
		// TODO Auto-generated method stub
		return estudianteDao.read(id);
	}

	@Override
	public Map<String, Object> readAll() {
		// TODO Auto-generated method stub
		return estudianteDao.readAll();
	}

}
