package pe.edu.upeu.sysrubricas.serviceImp;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.sysrubricas.dao.Nivel_logroDao;
import pe.edu.upeu.sysrubricas.dao.SemestreDao;
import pe.edu.upeu.sysrubricas.entity.Semestre;
import pe.edu.upeu.sysrubricas.service.SemestreService;

@Service
public class SemestreServiceImpl implements SemestreService{
	

	@Autowired
	private SemestreDao semestredao;

	@Override
	public int create(Semestre s) {
		// TODO Auto-generated method stub
		return semestredao.create(s);
	}

	@Override
	public int update(Semestre s) {
		// TODO Auto-generated method stub
		return semestredao.update(s);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return semestredao.delete(id);
	}

	@Override
	public Map<String, Object> read(int id) {
		// TODO Auto-generated method stub
		return semestredao.read(id);
	}

	@Override
	public Map<String, Object> readAll() {
		// TODO Auto-generated method stub
		return semestredao.readAll();
	}

}
