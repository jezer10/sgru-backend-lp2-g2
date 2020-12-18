package pe.edu.upeu.sysrubricas.serviceImp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.sysrubricas.dao.Nivel_Competencias_CursoDao;
import pe.edu.upeu.sysrubricas.entity.Nivel_Competencias_Curso;
import pe.edu.upeu.sysrubricas.service.Nivel_Competencias_CursoService;

@Service
public class Nivel_Competencias_CursoServiceImpl implements Nivel_Competencias_CursoService{
	@Autowired
	public Nivel_Competencias_CursoDao nivel_competencias_cursoDao;

	@Override
	public int create(Nivel_Competencias_Curso ncc) {
		// TODO Auto-generated method stub
		return nivel_competencias_cursoDao.create(ncc);
	}

	@Override
	public int update(Nivel_Competencias_Curso ncc) {
		// TODO Auto-generated method stub
		return nivel_competencias_cursoDao.update(ncc);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return nivel_competencias_cursoDao.delete(id);
	}

	@Override
	public Map<String, Object> read(int id) {
		// TODO Auto-generated method stub
		return nivel_competencias_cursoDao.read(id);
	}

	@Override
	public List<Map<String, Object>> readAll() {
		// TODO Auto-generated method stub
		return nivel_competencias_cursoDao.readAll();
	}
	
}

