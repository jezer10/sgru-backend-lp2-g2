package pe.edu.upeu.sysrubricas.serviceImp;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.sysrubricas.dao.EstadoCivilDao;
import pe.edu.upeu.sysrubricas.service.EstadoCivilService;
@Service
public class EstadoCivilServiceImp implements EstadoCivilService {
	@Autowired
	private EstadoCivilDao estadoCivilDao;
	@Override
	public Map<String, Object> readAll() {
		// TODO Auto-generated method stub
		return estadoCivilDao.readAll();
	}

}
