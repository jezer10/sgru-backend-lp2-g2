package pe.edu.upeu.sysrubricas.serviceImp;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.sysrubricas.dao.Plan_cursoDao;
import pe.edu.upeu.sysrubricas.entity.Plan_curso;
import pe.edu.upeu.sysrubricas.service.Plan_cursoService;

@Service
public class Plan_cursoServiceImpl implements Plan_cursoService{
	@Autowired
	private Plan_cursoDao plan_cursoDao;
	@Override
	public int create(Plan_curso pc) {
		return plan_cursoDao.create(pc);
	}

	@Override
	public int update(Plan_curso pc) {
		return plan_cursoDao.update(pc);
	}

	@Override
	public int delete(int id) {
		return plan_cursoDao.delete(id);
	}

	@Override
	public Map<String, Object> read(int id) {
		return plan_cursoDao.read(id);
	}

	@Override
	public Map<String, Object> readAll() {
		return plan_cursoDao.readAll();
	}

	@Override
	public Map<String, Object> readCurso() {
		return plan_cursoDao.readCurso();
	}

	@Override
	public Map<String, Object> readPlan() {
		return plan_cursoDao.readPlan();
	}

	@Override
	public Map<String, Object> readAll2() {
		return plan_cursoDao.readAll2();
	}

	@Override
	public Map<String, Object> readCiclo() {
		return plan_cursoDao.readCiclo();
	}
}
