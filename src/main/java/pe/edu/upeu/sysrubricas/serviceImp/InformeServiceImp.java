package pe.edu.upeu.sysrubricas.serviceImp;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.sysrubricas.dao.InformeDao;
import pe.edu.upeu.sysrubricas.service.InformeService;
@Service
public class InformeServiceImp implements InformeService{
	@Autowired
	private InformeDao informeDao;
	@Override
	public Map<String, Object> readInformeGeneral(int ua_id, int semestre_id) {
		// TODO Auto-generated method stub
		return informeDao.readInformeGeneral(ua_id, semestre_id);
	}

	@Override
	public Map<String, Object> readInformeIndividual(int ua_id, int semestre_id, int utils_id) {
		// TODO Auto-generated method stub
		return informeDao.readInformeIndividual(ua_id, semestre_id, utils_id);
	}

	@Override
	public Map<String, Object> readAllInformeUAC() {
		// TODO Auto-generated method stub
		return informeDao.readAllInformeUAC();
	}

	@Override
	public Map<String, Object> readAllInformeUAF(int id) {
		// TODO Auto-generated method stub
		return informeDao.readAllInformeUAF(id);
	}

	@Override
	public Map<String, Object> readAllInformeUAPA(int id) {
		// TODO Auto-generated method stub
		return informeDao.readAllInformeUAPA(id);
	}

}
