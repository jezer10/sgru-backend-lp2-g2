package pe.edu.upeu.sysrubricas.serviceImp;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.sysrubricas.dao.Nivel_Competencias_CursoDao;
import pe.edu.upeu.sysrubricas.entity.Nivel_Competencias_Curso;
import pe.edu.upeu.sysrubricas.service.Nivel_Competencias_CursoService;

@Service

public class Nivel_Competencias_CursoServiceImpl  implements Nivel_Competencias_CursoService {
	@Autowired
	private Nivel_Competencias_CursoDao nivel_competencias_cursoDao;

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
	public Map<String, Object> readAll() {
		// TODO Auto-generated method stub
		return nivel_competencias_cursoDao.readAll();
	}

	@Override
	public Map<String, Object> readAll2() {
		// TODO Auto-generated method stub
		return nivel_competencias_cursoDao.readAll2();
	}

	@Override
	public Map<String, Object> readCurso() {
		// TODO Auto-generated method stub
		return nivel_competencias_cursoDao.readCurso();
	}

	@Override
	public Map<String, Object> readPlan() {
		// TODO Auto-generated method stub
		return nivel_competencias_cursoDao.readPlan();
	}

	@Override
	public Map<String, Object> readCiclo() {
		// TODO Auto-generated method stub
		return nivel_competencias_cursoDao.readCiclo();
	}

	@Override
	public Map<String, Object> readTipo_comp() {
		// TODO Auto-generated method stub
		return nivel_competencias_cursoDao.readTipo_comp();
	}

	@Override
	public Map<String, Object> readLinea() {
		// TODO Auto-generated method stub
		return nivel_competencias_cursoDao.readLinea();
	}

	@Override
	public 	Map<String, Object> readCompetencia() {
		// TODO Auto-generated method stub
		return nivel_competencias_cursoDao.readCompetencia();
	}

	@Override
	public Map<String, Object> readNivel() {
		// TODO Auto-generated method stub
		return nivel_competencias_cursoDao.readNivel();
	}
}
