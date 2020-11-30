
package pe.edu.upeu.sysrubricas.serviceImp;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.sysrubricas.dao.EvaluacionDao;
import pe.edu.upeu.sysrubricas.entity.Evaluacion;
import pe.edu.upeu.sysrubricas.service.EvaluacionService;

@Service
public class EvaluacionServiceImp implements EvaluacionService { 
	
	@Autowired
	private EvaluacionDao evaluacionDao;

	@Override
	public int create(Evaluacion eva) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Evaluacion eva) {
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
