package pe.edu.upeu.sysrubricas.serviceImp;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.sysrubricas.dao.Sys_numericoDao;
import pe.edu.upeu.sysrubricas.entity.Sys_numerico;
import pe.edu.upeu.sysrubricas.service.Sys_numericoService;

@Service
public class Sys_numericoServiceImp implements Sys_numericoService {
	
	@Autowired
	private Sys_numericoDao sys_numericoDao;

	@Override
	public int create(Sys_numerico snum) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Sys_numerico snum) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Map<String, Object> read(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> readAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
