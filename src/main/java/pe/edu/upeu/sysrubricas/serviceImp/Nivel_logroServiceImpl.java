package pe.edu.upeu.sysrubricas.serviceImp;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.sysrubricas.dao.Nivel_logroDao;

import pe.edu.upeu.sysrubricas.entity.Nivel_logro;
import pe.edu.upeu.sysrubricas.service.Nivel_logroService;
@Service

public class Nivel_logroServiceImpl implements Nivel_logroService  {
	@Autowired

	private Nivel_logroDao nivel_logrodao;

	@Override
	public int create(Nivel_logro l) {
		// TODO Auto-generated method stub
		return nivel_logrodao.create(l);
	}

	@Override
	public int update(Nivel_logro l) {
		// TODO Auto-generated method stub
		return nivel_logrodao.update(l);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return nivel_logrodao.delete(id);
	}

	@Override
	public Map<String, Object> read(int id) {
		// TODO Auto-generated method stub
		return nivel_logrodao.read(id);
	}

	@Override
	public Map<String, Object> readAll() {
		// TODO Auto-generated method stub
		return nivel_logrodao.readAll();
	}
}
