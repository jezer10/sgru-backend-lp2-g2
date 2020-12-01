package pe.edu.upeu.sysrubricas.serviceImp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.sysrubricas.dao.CursoDao;
import pe.edu.upeu.sysrubricas.entity.Curso;
import pe.edu.upeu.sysrubricas.service.CursoService;

@Service
public class CursoServiceImpl implements CursoService{
	@Autowired
	private CursoDao cursoDao;
	
	@Override
	public int create(Curso c) {
		return cursoDao.create(c);
	}

	@Override
	public int update(Curso c) {
		return cursoDao.update(c);
	}

	@Override
	public int delete(int id) {
		return cursoDao.delete(id);
	}

	@Override
	public Map<String, Object> read(int id) {
		return cursoDao.read(id);
	}

	@Override
	public Map<String, Object> readAll() {
		return cursoDao.readAll();
	}

	@Override
	public List<Map<String, Object>> list() {
		return cursoDao.list();
	}
	
}
