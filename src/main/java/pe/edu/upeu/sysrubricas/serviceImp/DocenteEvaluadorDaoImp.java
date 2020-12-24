package pe.edu.upeu.sysrubricas.serviceImp;

import java.util.Map;

import org.springframework.stereotype.Repository;

import pe.edu.upeu.sysrubricas.entity.DocenteEvaluador;
import pe.edu.upeu.sysrubricas.service.DocenteEvaluadorService;
@Repository
public class DocenteEvaluadorDaoImp implements DocenteEvaluadorService{

	@Override
	public void create(DocenteEvaluador docenteEvaluador) {
		
	}

	@Override
	public void update(DocenteEvaluador docenteEvaluador) {
		// TODO Auto-generated method stub
		
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
