package pe.edu.upeu.sysrubricas.serviceImp;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.sysrubricas.dao.TipoEvaluadorDao;
import pe.edu.upeu.sysrubricas.service.TipoEvaluadorService;
@Service
public class TipoEvaluadorServiceImp implements TipoEvaluadorService{
	@Autowired
	private TipoEvaluadorDao tipoEvaluadorDao;
	@Override
	public Map<String, Object> read(int id) {
		// TODO Auto-generated method stub
		return tipoEvaluadorDao.read(id);
	}

	@Override
	public Map<String, Object> readAll() {
		// TODO Auto-generated method stub
		return tipoEvaluadorDao.readAll();
	}

}
